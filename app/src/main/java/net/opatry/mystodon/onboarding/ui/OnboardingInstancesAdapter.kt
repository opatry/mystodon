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

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import net.opatry.mystodon.R
import net.opatry.mystodon.databinding.OnboardingMastodonInstanceCellLayoutBinding

class OnboardingInstanceViewHolder(private val binding: OnboardingMastodonInstanceCellLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(instance: OnboardingInstance, callback: (OnboardingInstance) -> Unit) {
        val imageCornerRadius = binding.root.resources.getDimension(R.dimen.onboarding_instance_cell_icon_corner_radius)
        binding.root.isSelected = instance.isSelected
        binding.onboardingMastodonInstanceCellIcon.load(instance.thumbnailUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_baseline_language_24) // FIXME
            fallback(R.drawable.ic_launcher_foreground) // FIXME
            transformations(RoundedCornersTransformation(imageCornerRadius)) // TODO Squircle
        }

        binding.onboardingMastodonInstanceCellTitle.text =
            binding.root.resources.getString(R.string.onboarding_instance_name_title, instance.name)
        binding.onboardingMastodonInstanceCellDescription.text = instance.description
        binding.onboardingMastodonInstanceCellDescription.isVisible = instance.description.isNotBlank()
        binding.onboardingMastodonInstanceCellUserCount.text = instance.usersCount.toString()
        binding.onboardingMastodonInstanceCellUserCount.isVisible = instance.usersCount > 0
        binding.onboardingMastodonInstanceCellLanguages.text = instance.languages.joinToString(", ")
        binding.onboardingMastodonInstanceCellLanguages.isVisible = instance.languages.isNotEmpty()
        binding.onboardingMastodonInstanceCellExactMatch.isVisible = instance.isExactMatch

        binding.root.setOnClickListener {
            callback.invoke(instance)
        }
    }

    fun unbind() {
        binding.root.setOnClickListener(null)
    }
}

class OnboardingInstancesAdapter(
    private val callback: (OnboardingInstance) -> Unit,
) : ListAdapter<OnboardingInstance, OnboardingInstanceViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingInstanceViewHolder {
        return OnboardingInstanceViewHolder(
            OnboardingMastodonInstanceCellLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnboardingInstanceViewHolder, position: Int) {
        holder.bind(getItem(position), callback)
    }

    override fun onViewRecycled(holder: OnboardingInstanceViewHolder) {
        super.onViewRecycled(holder)
        holder.unbind()
    }

    override fun submitList(list: List<OnboardingInstance>?) {
        if (list == null) {
            super.submitList(null)
        } else {
            super.submitList(ArrayList(list)) // force DiffUtil by creating a new list
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<OnboardingInstance>() {
            override fun areItemsTheSame(oldItem: OnboardingInstance, newItem: OnboardingInstance): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: OnboardingInstance, newItem: OnboardingInstance): Boolean {
                return oldItem == newItem
            }
        }
    }
}
