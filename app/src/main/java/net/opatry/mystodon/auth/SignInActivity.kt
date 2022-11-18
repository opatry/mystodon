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

package net.opatry.mystodon.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.opatry.mystodon.api.MastodonApi
import net.opatry.mystodon.api.mastodonAuthorizeUri
import net.opatry.mystodon.data.AccountRepository
import net.opatry.mystodon.databinding.AuthCallbackActivityBinding
import javax.inject.Inject

private const val appClientName = "mystodon"

/**
 * see AndroidManifest `<intent-filter>` for [SignInActivity]
 */
private const val redirectUri = "mystodon://auth-callback"
private const val scope = "read write follow push"
private const val website = "https://mystodon.opatry.net"

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {
    @Inject
    lateinit var accountRepository: AccountRepository

    @Inject
    lateinit var mastodonApi: MastodonApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val token = accountRepository.token
        if (token != null) {
            setResult(RESULT_OK)
            finish()
        }
        // FIXME how to create mastodonApi before we know the Url to use but still use mastodonApi to retrieve App
//            val instanceUrl = requireNotNull(intent.getStringExtra(MASTODON_INSTANCE_URL_KEY)) {
//                "No instance URL provided"
//            }
        val instanceUrl = "https://androiddev.social" // FIXME also hardcoded in MastodonModule.provideMastodonApi

        lifecycleScope.launch(Dispatchers.Main) {
            // FIXME needed at each launch? when is it revoked? never? store it in sharedprefs/db?
            val app = withContext(Dispatchers.IO) {
                mastodonApi.getApp(
                    clientName = appClientName,
                    redirectUris = redirectUri,
                    scopes = scope,
                    website = website
                )
            }

            val clientId = checkNotNull(app.clientId) { "Application does not have expected clientId." }

            accountRepository.app = app
            CustomTabsIntent.Builder()
                .setShareState(CustomTabsIntent.SHARE_STATE_OFF)
                .setShowTitle(true)
                .build()
                .launchUrl(
                    this@SignInActivity,
                    mastodonAuthorizeUri(instanceUrl, clientId, redirectUri, scope)
                )
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        val data = intent?.data
        val authCodeError = data?.getQueryParameter("error")
        if (authCodeError != null) {
            val errorDescription = data.getQueryParameter("error_description")
            val binding = AuthCallbackActivityBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.authCallbackErrorCause.text = authCodeError
            binding.authCallbackErrorDetail.text = errorDescription
        } else {
            val code = data?.getQueryParameter("code")
            val app = checkNotNull(accountRepository.app)

            // TODO better error management on app clientId/clientSecret state management
            val (clientId, clientSecret) = checkNotNull(app.clientId) { "Application does not have expected clientId." } to
                    checkNotNull(app.clientSecret) { "Application does not have expected clientSecret." }

            lifecycleScope.launch(Dispatchers.Main) {
                val token = withContext(Dispatchers.IO) {
                    // TODO do that only once + HTTP Client interceptor
                    mastodonApi.getToken(
                        grantType = "authorization_code",
                        clientId = clientId,
                        clientSecret = clientSecret,
                        redirectUri = redirectUri,
                        scope = scope,
                        code = code
                    )
                }
                accountRepository.token = token
                setResult(RESULT_OK)
                finish()
            }
        }
    }

    companion object {
        private const val MASTODON_INSTANCE_URL_KEY = "MASTODON_INSTANCE_URL_KEY"
        fun newIntent(context: Context, mastodonInstanceUrl: String): Intent =
            Intent(context, SignInActivity::class.java).apply {
                putExtra(MASTODON_INSTANCE_URL_KEY, mastodonInstanceUrl)
            }
    }
}
