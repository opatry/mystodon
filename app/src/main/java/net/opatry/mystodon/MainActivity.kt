package net.opatry.mystodon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.CircleCropTransformation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.opatry.mystodon.api.MastodonApi
import net.opatry.mystodon.api.mastodonAuthorizeUri
import net.opatry.mystodon.data.AccountRepository
import net.opatry.mystodon.data.MastodonInstance
import net.opatry.mystodon.databinding.MainActivityBinding
import net.opatry.mystodon.databinding.OnboardingActivityBinding
import net.opatry.mystodon.ui.OnboardingInstancesAdapter
import javax.inject.Inject

private const val appClientName = "mystodon"

/**
 * see AndroidManifest `<intent-filter>` for [AuthCallbackActivity]
 */
private const val redirectUri = "mystodon://auth-callback"
private const val scope = "read write follow push"
private const val website = "https://mystodon.opatry.net"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    @Inject
    lateinit var accountRepository: AccountRepository

    @Inject
    lateinit var mastodonInstance: MastodonInstance

    @Inject
    lateinit var mastodonApi: MastodonApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (accountRepository.code.isNullOrEmpty()) {
            proceedWithAuthenticationFlow()
        } else {
            binding = MainActivityBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // TODO better error management on app clientId/clientSecret state management
            val app = checkNotNull(mastodonInstance.app) { "Application is not initialized as expected." }
            val (clientId, clientSecret) = checkNotNull(app.clientId) { "Application does not have expected clientId." } to
                    checkNotNull(app.clientSecret) { "Application does not have expected clientSecret." }
            lifecycleScope.launch(Dispatchers.Main) {
                val account = withContext(Dispatchers.IO) {
                    // TODO do that only once + HTTP Client interceptor
                    val token = mastodonApi.getToken(
                        grantType = "authorization_code",
                        clientId = clientId,
                        clientSecret = clientSecret,
                        redirectUri = redirectUri,
                        scope = scope,
                        code = accountRepository.code
                    )

                    mastodonApi.getAccount(token.authorization)
                }

                with(binding) {
                    // TODO reuse account.displayName
                    // TODO replace emojis key in string with spannable image pointing to URL (can be animated or not)
                    profileUsername.text = getString(R.string.profile_username, account.username)
                    profileFollowingCount.text = getString(R.string.profile_following_count, account.followingCount)
                    profileFollowersCount.text = getString(R.string.profile_followers_count, account.followersCount)
                    // TODO static avatar URL with animated if available
                    profileAvatar.load(account.avatarStaticUrl) {
                        crossfade(true)
                        placeholder(R.drawable.ic_baseline_account_circle_24)
                        transformations(CircleCropTransformation())
                    }
                }
            }
        }
    }

    private fun proceedWithAuthenticationFlow() {
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

            mastodonInstance.app = app
            val clientId = checkNotNull(app.clientId) { "Application does not have expected clientId." }

            CustomTabsIntent.Builder()
                .setShareState(CustomTabsIntent.SHARE_STATE_OFF)
                .setShowTitle(true)
                .build()
                .launchUrl(
                    this@MainActivity,
                    mastodonAuthorizeUri(mastodonInstance.url, clientId, redirectUri, scope)
                )
        }
    }
}
