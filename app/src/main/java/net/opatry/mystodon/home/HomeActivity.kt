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

package net.opatry.mystodon.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.CircleCropTransformation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.opatry.mystodon.R
import net.opatry.mystodon.api.MastodonApi
import net.opatry.mystodon.data.AccountRepository
import net.opatry.mystodon.databinding.ProfileActivityBinding
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ProfileActivityBinding

    @Inject
    lateinit var accountRepository: AccountRepository

    @Inject
    lateinit var mastodonApi: MastodonApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ProfileActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO better error management on token state management
        val token = checkNotNull(accountRepository.token) {
            "No token available"
        }
        // TODO Authorization interceptor in mastodonApi
        lifecycleScope.launch(Dispatchers.Main) {
            val account = withContext(Dispatchers.IO) {
                mastodonApi.getAccount(token.authorization)
            }

            with(binding) {
                // TODO reuse account.displayName
                // TODO replace emojis key in string with spannable image pointing to URL (can be animated or not)
                profileUsername.text = getString(R.string.profile_username, account.username)
                profileFollowingCount.text =
                    getString(R.string.profile_following_count, account.followingCount)
                profileFollowersCount.text =
                    getString(R.string.profile_followers_count, account.followersCount)
                // TODO static avatar URL with animated if available
                profileAvatar.load(account.avatarStaticUrl) {
                    crossfade(true)
                    placeholder(R.drawable.ic_baseline_account_circle_24)
                    transformations(CircleCropTransformation())
                }
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }
}
