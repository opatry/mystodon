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

package net.opatry.mystodon

import android.app.Application
import net.opatry.mystodon.api.MastodonApi
import net.opatry.mystodon.data.AccountRepository
import net.opatry.mystodon.data.MastodonInstance
import net.opatry.mystodon.di.AccountRepositoryProvider
import net.opatry.mystodon.di.MastodonApiProvider
import net.opatry.mystodon.di.MastodonInstanceProvider
import net.opatry.mystodon.di.RetrofitProvider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MystodonApp
    : Application(), MastodonInstanceProvider, RetrofitProvider, MastodonApiProvider, AccountRepositoryProvider {

    override val mastodonInstance: MastodonInstance =
        MastodonInstance("androiddev.social", "https://androiddev.social/")

    override val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(mastodonInstance.url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override val mastodonApi: MastodonApi = retrofit.create()

    override val accountRepository: AccountRepository = AccountRepository()

}
