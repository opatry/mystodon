package net.opatry.mystodon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.CircleCropTransformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.opatry.mystodon.api.mastodonAuthorizeUri
import net.opatry.mystodon.databinding.MainActivityBinding
import net.opatry.mystodon.di.AccountRepositoryProvider
import net.opatry.mystodon.di.MastodonApiProvider
import net.opatry.mystodon.di.MastodonInstanceProvider

private const val appClientName = "mystodon"

/**
 * see AndroidManifest `<intent-filter>` for [AuthCallbackActivity]
 */
private const val redirectUri = "mystodon://auth-callback"
private const val scope = "read write follow push"
private const val website = "https://mystodon.opatry.net"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    // TODO Hilt DI instead of "manual DI"
    private val accountRepository by lazy { (application as AccountRepositoryProvider).accountRepository }
    private val mastodonInstance by lazy { (application as MastodonInstanceProvider).mastodonInstance }
    private val mastodonApi by lazy { (application as MastodonApiProvider).mastodonApi }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (accountRepository.code.isNullOrEmpty()) {
            proceedWithAuthenticationFlow()
        } else {
            binding = MainActivityBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // TODO better error management an app clientId/clientSecret state management
            val app = checkNotNull(mastodonInstance.app)
            lifecycleScope.launch(Dispatchers.Main) {
                val account = withContext(Dispatchers.IO) {
                    // TODO do that only once + HTTP Client interceptor
                    val token = mastodonApi.getToken(
                        grantType = "authorization_code",
                        clientId = app.clientId,
                        clientSecret = app.clientSecret,
                        redirectUri = redirectUri,
                        scope = scope,
                        code = accountRepository.code
                    )

                    mastodonApi.getAccount("Bearer ${token.accessToken}")
                }

                with(binding) {
                    // TODO reuse account.displayName and replace emojis key in string with spannable image pointing to URL (can be animated or not)
                    profileUsername.text = getString(R.string.profile_username, account.username)
                    profileFollowingCount.text = getString(R.string.profile_following_count, account.followingCount)
                    profileFollowersCount.text = getString(R.string.profile_followers_count, account.followersCount)
                    profileAvatar.load(account.avatar) {
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

            CustomTabsIntent.Builder()
                .setShareState(CustomTabsIntent.SHARE_STATE_OFF)
                .setShowTitle(true)
                .build()
                .launchUrl(
                    this@MainActivity,
                    mastodonAuthorizeUri(mastodonInstance.authority, app.clientId, redirectUri, scope)
                )
        }
    }
}
