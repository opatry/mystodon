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

package net.opatry.mystodon.account

data class MastodonToken(
    val tokenType: String,
    val accessToken: String,
) {
    val authorization: String
        get() = "$tokenType $accessToken"
}

interface AccountManager {

    /**
     * Instance Url chosen at the moment by user, especially useful to authenticate a user.
     */
    val currentInstanceUrl: String?

    /**
     * All accounts currently registered by user
     */
    val accounts: List<MastodonToken>

    /**
     * Account being used at the moment by user
     */
    val currentAccount: MastodonToken?

    fun addAccount(account: MastodonToken)
    fun removeAccount(account: MastodonToken)
    fun switchAccount(account: MastodonToken)
    fun switchInstance(instanceUrl: String)
}

// TODO persistence layer
// TODO mastodonApi
class AccountManagerImpl : AccountManager {
    override var currentInstanceUrl: String? = null
        private set

    private val accountsSet = mutableSetOf<MastodonToken>()
    override val accounts: List<MastodonToken>
        get()= accountsSet.toList()

    override var currentAccount: MastodonToken? = null
        private set

    override fun switchInstance(instanceUrl: String) {
        // can't presume of account to choose when instance changes
        currentAccount = null
        currentInstanceUrl = instanceUrl
    }

    override fun addAccount(account: MastodonToken) {
        accountsSet += account
        if (currentAccount == null) {
            currentAccount = account
        }
    }

    override fun removeAccount(account: MastodonToken) {
        // TODO revoke token
        accountsSet -= account
    }

    override fun switchAccount(account: MastodonToken) {
        if (accountsSet.contains(account)) {
            currentAccount = account
        }
    }
}
