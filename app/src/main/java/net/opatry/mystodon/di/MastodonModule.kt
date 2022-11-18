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

package net.opatry.mystodon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.opatry.mystodon.api.MastodonApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object MastodonModule {

    @Singleton
    @Provides
    fun provideMastodonApi(): MastodonApi {
        // FIXME URL from settings but provided at runtime if instance chose, how to singleton it??!!!!!!
        val retrofit = Retrofit.Builder()
            .baseUrl("https://androiddev.social")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }
}

/*
val httpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .addNetworkInterceptor { chain ->
            val originalRequest = chain.request()
//            val requestWithUserAgent = originalRequest.newBuilder()
//                .header("User-Agent", "Mystodon/${BuildConfig.VERSION_NAME}") // TODO Android version
//                .build()
//            chain.proceed(requestWithUserAgent)
            chain.proceed(originalRequest)
        }
        .build()
 */
