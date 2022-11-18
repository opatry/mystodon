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

import android.os.Build
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.opatry.mystodon.BuildConfig
import net.opatry.mystodon.api.MastodonApi
import net.opatry.mystodon.auth.AuthHttpInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object MastodonModule {
    private val USER_AGENT = "Mystodon/${BuildConfig.VERSION_NAME} Android/${Build.VERSION.RELEASE}"

    @Singleton
    @Provides
    fun provideMastodonApi(authHttpInterceptor: AuthHttpInterceptor): MastodonApi {
        val httpClientBuilder = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val decoratedRequest = originalRequest.newBuilder()
                    .header("User-Agent", USER_AGENT)
                    .build()
                chain.proceed(decoratedRequest)
            }
            .addInterceptor(authHttpInterceptor)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.HEADERS
            }
            httpClientBuilder.addInterceptor(loggingInterceptor)
        }

        val httpClient = httpClientBuilder.build()

        // This URL will never be called (hopefully!), we
        // must provide a Url at setup time but it will be dynamically replaced by AuthHttpInterceptor
        // once the user chooses its Mastodon Instance.
        val retrofit = Retrofit.Builder()
            .baseUrl("https://mystodon.hook")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }
}

