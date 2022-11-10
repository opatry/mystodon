package net.opatry.mystodon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.opatry.mystodon.di.AccountRepositoryProvider
import net.opatry.mystodon.di.MastodonApiProvider
import net.opatry.mystodon.di.MastodonInstanceProvider

private const val appClientName = "mystodon"
private const val redirectUri = "mystodon://auth-callback"
private const val scope = "read write follow push"
private const val website = "https://mystodon.opatry.net"

class MainActivity : AppCompatActivity() {

    // TODO Hilt DI instead of "manual DI"
    private val accountRepository by lazy { (application as AccountRepositoryProvider).accountRepository }
    private val mastodonInstance by lazy { (application as MastodonInstanceProvider).mastodonInstance }
    private val mastodonApi by lazy { (application as MastodonApiProvider).mastodonApi }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (accountRepository.code.isNullOrEmpty()) {
            proceedWithAuthenticationFlow()
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
        }
    }
}
