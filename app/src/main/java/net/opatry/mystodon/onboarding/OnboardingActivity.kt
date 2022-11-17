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

package net.opatry.mystodon.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import dagger.hilt.android.AndroidEntryPoint
import net.opatry.mystodon.databinding.OnboardingActivityBinding
import net.opatry.mystodon.onboarding.ui.OnboardingInstancesAdapter
import net.opatry.mystodon.onboarding.ui.OnboardingViewModel
import net.opatry.mystodon.onboarding.ui.OnboardingViewModelImpl

data class OnboardingResult(val selectedInstanceUrl: String) {
    constructor(intent: Intent) : this(requireNotNull(intent.getStringExtra(INSTANCE_URL_KEY)) {
        "Intent does not provide expected data, is it built with OnboardingResult class?"
    })

    val asIntent: Intent
        get() = Intent().apply {
            putExtra(INSTANCE_URL_KEY, selectedInstanceUrl)
        }

    companion object {
        private const val INSTANCE_URL_KEY = "INSTANCE_URL_KEY"
    }
}

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: OnboardingActivityBinding

    private val viewModel: OnboardingViewModel by viewModels<OnboardingViewModelImpl>()

    private val instancesAdapter = OnboardingInstancesAdapter {
        viewModel.selectInstance(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = OnboardingActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.onboardingInstancesFilterResult.adapter = instancesAdapter

        viewModel.state.observe(this) { state ->
            // TODO loading state
            instancesAdapter.submitList(state.instances)
            // TODO: try keeping selected instance index visible if any, otherwise scroll to top?
            //  either user scrolled hiding the selected item, then further filtered the list: maybe no scroll expected
            //  or the new filter excluded the selected item, list filtered enough so that we scroll to top?
            //            binding.onboardingInstancesFilterResult.scrollToPosition(0)
            binding.onboardingInstancesFilterResult.isVisible = state.isInstancesListVisible
            binding.onboardingInstancesFilterNoResult.isVisible = state.isNoResultVisible
            binding.onboardingContinue.isEnabled = state.isContinueEnabled
        }

        binding.onboardingInstanceName.doAfterTextChanged { editable ->
            viewModel.filterInstances(editable.toString())
        }
    }

    override fun onStart() {
        super.onStart()

        binding.onboardingContinue.setOnClickListener {
            val instanceUrl = checkNotNull(viewModel.selectedInstanceUrl) {
                "Shouldn't be possible to proceed onboarding without selected instance"
            }
            setResult(RESULT_OK, OnboardingResult(instanceUrl).asIntent)
            finish()
        }
    }

    override fun onStop() {
        binding.onboardingContinue.setOnClickListener(null)

        super.onStop()
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, OnboardingActivity::class.java)
    }
}
