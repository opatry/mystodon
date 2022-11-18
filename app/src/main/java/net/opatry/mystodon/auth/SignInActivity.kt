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
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.opatry.mystodon.R
import net.opatry.mystodon.account.AccountManager
import net.opatry.mystodon.account.MastodonToken
import net.opatry.mystodon.api.MastodonApi
import net.opatry.mystodon.api.mastodonAuthorizeUri
import net.opatry.mystodon.databinding.AuthCallbackActivityBinding
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private const val appClientName = "mystodon"

private const val scope = "read write follow push"
private const val website = "https://mystodon.opatry.net"

inline operator fun <reified T> SavedStateHandle.invoke(): ReadWriteProperty<Any, T?> = object : ReadWriteProperty<Any, T?> {
    private fun key(thisRef: Any, property: KProperty<*>): String = "${thisRef.javaClass.name}/${property.name}"

    override fun getValue(thisRef: Any, property: KProperty<*>): T? {
        return get(key(thisRef, property))
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T?) {
        set(key(thisRef, property), value)
    }
}

@HiltViewModel
class SignInViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    var clientId: String? by savedStateHandle()
    var clientSecret: String? by savedStateHandle()
}

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {
    @Inject
    lateinit var accountManager: AccountManager

    @Inject
    lateinit var mastodonApi: MastodonApi

    private val viewModel: SignInViewModel by viewModels()

    private val redirectUri by lazy {
        "${getString(R.string.auth_redirect_scheme)}://${getString(R.string.auth_redirect_host)}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val token = accountManager.currentAccount
        if (token != null) {
            setResult(RESULT_OK)
            finish()
        }

        val instanceUrl = requireNotNull(intent.getStringExtra(MASTODON_INSTANCE_URL_KEY)) {
            "No instance URL provided"
        }
        accountManager.switchInstance(instanceUrl)

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

            val clientSecret = checkNotNull(app.clientSecret) { "Application does not have expected clientSecret." }
            val clientId = checkNotNull(app.clientId) { "Application does not have expected clientId." }
            viewModel.clientSecret = clientSecret
            viewModel.clientId = clientId

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

            // TODO better error management on app clientId/clientSecret state management
            val clientId = checkNotNull(viewModel.clientId) { "Missing expected clientId." }
            val clientSecret = checkNotNull(viewModel.clientSecret) { "Missing expected clientSecret." }

            lifecycleScope.launch(Dispatchers.Main) {
                val token = withContext(Dispatchers.IO) {
                    // TODO do that only once
                    mastodonApi.getToken(
                        grantType = "authorization_code",
                        clientId = clientId,
                        clientSecret = clientSecret,
                        redirectUri = redirectUri,
                        scope = scope,
                        code = code
                    )
                }
                accountManager.addAccount(MastodonToken(token.tokenType, token.accessToken))
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
