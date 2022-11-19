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

package net.opatry.mystodon.api

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Query

data class JoinMastodonInstance(

    @SerializedName("domain")
    val domain: String,

    @SerializedName("version")
    val version: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("languages")
    val languages: List<String>,

    @SerializedName("region")
    val region: String,

    @SerializedName("categories")
    val categories: List<String>,

    @SerializedName("proxied_thumbnail")
    val proxiedThumbnailUrl: String,

    @SerializedName("total_users")
    val totalUsersCount: Long,

    @SerializedName("last_week_users")
    val lastWeekUsersCount: Long,

    @SerializedName("approval_required")
    val approvalRequired: Boolean,

    @SerializedName("language")
    val language: String,

    @SerializedName("category")
    val category: String,
)

data class JoinMastodonCategory(

    @SerializedName("category")
    val category: String,

    @SerializedName("servers_count")
    val serversCount: Long,
)

interface JoinMastodonApi {
    @GET("servers")
    suspend fun servers(
        @Query("language") language: String? = null,
        @Query("category") category: String? = null,
        @Query("region") region: String? = null,
    ): List<JoinMastodonInstance>

    @GET("categories")
    suspend fun categories(
        @Query("language") language: String? = null,
    ): List<JoinMastodonCategory>
}
