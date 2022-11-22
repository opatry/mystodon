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

package net.opatry.mystodon.onboarding.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import net.opatry.mystodon.BuildConfig
import net.opatry.mystodon.api.InstancesSocialApi
import net.opatry.mystodon.api.JoinMastodonApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(ViewModelComponent::class)
internal object OnboardingModule {

    @Provides
    fun provideJoinMastodonApi(): JoinMastodonApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.joinmastodon.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }

    @Provides
    fun provideInstancesSocialApi(): InstancesSocialApi {
        val okHttpClient = OkHttpClient.Builder()
            // FIXME .authenticator doing the same doesn't work as intented
            .addInterceptor { chain ->
                val request = chain.request()
                if (request.header("Authorization") != null) {
                    chain.proceed(request)
                } else {
                    val decoratedRequest =
                        request.newBuilder().header("Authorization", "Bearer ${BuildConfig.INSTANCES_SOCIAL_TOKEN}")
                            .build()
                    chain.proceed(decoratedRequest)
                }
            }.build()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://instances.social/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }
}
