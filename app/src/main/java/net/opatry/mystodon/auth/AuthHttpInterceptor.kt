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

import net.opatry.mystodon.account.AccountManager
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthHttpInterceptor @Inject constructor(private val accountManager: AccountManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()

        val requestedUrl = accountManager.currentInstanceUrl?.toHttpUrl()
        if (requestedUrl != null) {
            val originalUrl = originalRequest.url
            if (originalUrl.host != requestedUrl.host) {
                val newUrl = originalRequest.url.newBuilder()
                    .scheme(requestedUrl.scheme)
                    .host(requestedUrl.host)
                    .build()
                requestBuilder.url(newUrl)
            }
            val currentAccount = accountManager.currentAccount
            if (currentAccount != null && currentAccount.authorization.isNotEmpty()) {
                requestBuilder.header("Authorization", currentAccount.authorization)
            }
        }
        val decoratedRequest = requestBuilder.build()
        return chain.proceed(decoratedRequest)
    }
}
