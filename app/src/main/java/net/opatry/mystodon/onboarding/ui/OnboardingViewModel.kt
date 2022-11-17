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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.opatry.mystodon.api.InstancesSocialApi
import javax.inject.Inject

data class OnboardingInstance(
    val id: String,
    val name: String,
    val description: String,
    val thumbnailUrl: String?,
    val usersCount: Long,
    val languages: List<String>,
    val isSelected: Boolean,
    val isExactMatch: Boolean,
) {
    // FIXME
    val url: String
        get() = "https://$name"
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
    private val instancesSocialApi: InstancesSocialApi,
) : ViewModel(), OnboardingViewModel {

    // TODO saveStateHandle

    private var selectedInstanceId: String? = null
    override val selectedInstanceUrl: String?
        get() = availableInstances.firstOrNull { it.id == selectedInstanceId }?.url

    private var filterQuery: String? = null

    private var availableInstances: List<OnboardingInstance> = emptyList()
    override val state = MutableLiveData(OnboardingScreenState())

    init {
        viewModelScope.launch(Dispatchers.Main) {
            // TODO deal with paging incrementally
            val instances = withContext(Dispatchers.IO) {
                // FIXME users or active_users?
                instancesSocialApi.list(
                    includeDead = false,
                    includeDown = false,
                    includeClosed = false,
                    minUsers = 1,
                    sortBy = "users",
                    sortOrder = "desc"
                )
            }
            availableInstances = withContext(Dispatchers.Default) {
                instances.instances.map {
                    OnboardingInstance(
                        it.id,
                        it.name,
                        it.info?.shortDescription ?: "",
                        it.thumbnailUrl,
                        it.usersCount,
                        it.info?.languages ?: emptyList(),
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
        selectedInstanceId = instance?.id
        filterInstances(filterQuery)
    }

    override fun filterInstances(query: String?) {
        val cleanedQuery = query?.trim()?.removePrefix("@")?.trim() ?: ""
        filterQuery = cleanedQuery
        viewModelScope.launch(Dispatchers.Main) {
            val uiInstances = if (cleanedQuery.isNotBlank()) {
                // TODO caching the result for a given query could improve situation where user press back>back>back on a query
                // TODO sort by + filter min user like for init list
                val instances = withContext(Dispatchers.IO) {
                    instancesSocialApi.search(cleanedQuery, inNameOnly = false)
                }
                // TODO if result is empty try exact match with MastodonApi
                withContext(Dispatchers.Default) {
                    instances.instances.map {
                        OnboardingInstance(
                            it.id,
                            it.name,
                            it.info?.shortDescription ?: "",
                            it.thumbnailUrl,
                            it.usersCount,
                            it.info?.languages ?: emptyList(),
                            isSelected = selectedInstanceId == it.id,
                            isExactMatch = cleanedQuery == it.name,
                        )
                    }
                }
            } else {
                availableInstances.map {
                    it.copy(
                        isSelected = selectedInstanceId == it.id,
                        isExactMatch = cleanedQuery == it.name,
                    )
                }
            }
            // FIXME requestedInstanceFound not in list but exists by checking MastodonApi
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
