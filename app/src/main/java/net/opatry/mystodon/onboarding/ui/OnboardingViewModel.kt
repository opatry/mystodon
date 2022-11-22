// Copyright (c) 2022 Olivier Patry
//
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation files (the "Software"),
// to deal in the Software without restriction, including without limitation
// the rights to use, copy, modify, merge, publish, distribute, sublicense,
// and/or sell copies of the Software, and to permit persons to whom the Software
// is furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
// OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
// IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
// CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
// TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
// OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package net.opatry.mystodon.onboarding.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.opatry.mystodon.api.JoinMastodonApi
import javax.inject.Inject

data class OnboardingInstance(
    val domain: String,
    val description: String,
    val thumbnailUrl: String?,
    val usersCount: Long,
    val languages: List<String>,
    val isSelected: Boolean = false,
    val isExactMatch: Boolean = false,
) {
    val url: String
        get() = "https://$domain"
}

data class OnboardingScreenState(
    val instances: List<OnboardingInstance> = emptyList(),
    val isInstancesListVisible: Boolean = false,
    val isNoResultVisible: Boolean = false,
    val isContinueEnabled: Boolean = false,
)

interface OnboardingViewModel {
    val selectedInstanceUrl: String?
    val state: LiveData<OnboardingScreenState>
    fun selectInstance(instance: OnboardingInstance?)
    fun filterInstances(query: String?)
}

@HiltViewModel
class OnboardingViewModelImpl
@Inject constructor(
    private val joinMastodonApi: JoinMastodonApi,
) : ViewModel(), OnboardingViewModel {
    private val mainDispatcher: CoroutineDispatcher = Dispatchers.Main
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    // TODO saveStateHandle

    private var selectedInstanceName: String? = null
    override val selectedInstanceUrl: String?
        get() = state.value?.instances?.firstOrNull { it.domain == selectedInstanceName }?.url

    private var filterQuery: String? = null

    private var availableInstances: List<OnboardingInstance> = emptyList()
    override val state = MutableLiveData(OnboardingScreenState())

    init {
        viewModelScope.launch(mainDispatcher) {
            val instances = withContext(ioDispatcher) {
                joinMastodonApi.servers()
            }
            availableInstances = withContext(defaultDispatcher) {
                instances.map {
                    OnboardingInstance(
                        domain = it.domain,
                        description = it.description,
                        thumbnailUrl = it.proxiedThumbnailUrl,
                        usersCount = it.totalUsersCount,
                        languages = it.languages,
                        isSelected = false,
                        isExactMatch = false,
                    )
                }
            }

            val hasInstances = availableInstances.isNotEmpty()
            state.value = OnboardingScreenState(
                instances = availableInstances,
                isInstancesListVisible = hasInstances,
                isNoResultVisible = !hasInstances,
                isContinueEnabled = false
            )
        }
    }

    override fun selectInstance(instance: OnboardingInstance?) {
        selectedInstanceName = instance?.domain
        filterInstances(filterQuery)
    }

    override fun filterInstances(query: String?) {
        val cleanedQuery = query?.trim()?.removePrefix("@")?.trim() ?: ""
        filterQuery = cleanedQuery
        viewModelScope.launch(mainDispatcher) {
            val uiInstances = if (cleanedQuery.isNotBlank()) {
                availableInstances.filter {
                    it.domain.contains(cleanedQuery, true) || it.description.contains(cleanedQuery, true)
                }
                // TODO if result is empty try exact match with MastodonApi
            } else {
                availableInstances
            }.map {
                it.copy(
                    isSelected = selectedInstanceName == it.domain,
                    isExactMatch = cleanedQuery == it.domain,
                )
            }.sortedBy { -it.usersCount }
            val hasInstances = uiInstances.isNotEmpty()
            state.value = OnboardingScreenState(
                instances = uiInstances,
                isInstancesListVisible = hasInstances,
                isNoResultVisible = !hasInstances,
                isContinueEnabled = uiInstances.any { it.isSelected || it.isExactMatch }
            )
        }
    }
}
