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

data class InstanceInfo(

    /**
     * "Dutch Mastodon server, for social contacts between people and with people."
     */
    @SerializedName("short_description")
    val shortDescription: String,
    /**
     * "Masotodonsocial is a new Dutch social network, where people can share information in a fun way and get in touch with each other."
     */
    @SerializedName("full_description")
    val fullDescription: String,
    /**
     * null
     */
    @SerializedName("topic")
    val topic: String? = null,
    /**
     * ["nl"]
     */
    @SerializedName("languages")
    val languages: List<String>,
    /**
     * true
     */
    @SerializedName("other_languages_accepted")
    val areOtherLanguagesAccepted: Boolean,
    /**
     * null
     */
    @SerializedName("federates_with")
    val federatesWith: String? = null,
    /**
     * [ "nudity_nocw", "nudity_all", "pornography_nocw", "pornography_all", "illegalContentLinks", "spam" ]
     */
    @SerializedName("prohibited_content")
    val prohibitedContent: List<String>, // FIXME should be a data class "boolean bit field"
    /**
     * [ "adult", "humor" ]
     */
    @SerializedName("categories")
    val categories: List<String>,
)

data class Instance(
    /**
     * "636ac54080bb3f03b435a3b3"
     */
    @SerializedName("id")
    val id: String,
    /**
     * "mastodonsocial.nl"
     */
    @SerializedName("name")
    val name: String,
    /**
     * "2022-11-08T21:08:16.015Z"
     */
    @SerializedName("added_at")
    val addedAt: String? = null,
    /**
     * "2022-11-15T19:40:58.740Z"
     */
    @SerializedName("updated_at")
    val updatedAt: String? = null,
    /**
     * "2022-11-15T19:40:58.740Z"
     */
    @SerializedName("checked_at")
    val checkedAt: String? = null,
    /**
     * 1
     */
    @SerializedName("uptime")
    val uptime: Long,
    /**
     * false
     */
    @SerializedName("up")
    val isUp: Boolean,
    /**
     * false
     */
    @SerializedName("dead")
    val isDead: Boolean,
    /**
     * "3.5.3"
     */
    @SerializedName("version")
    val version: String? = null,
    /**
     * false
     */
    @SerializedName("ipv6")
    val isIpv6: Boolean,
    /**
     * 5
     */
    @SerializedName("https_score")
    val httpsScore: Long? = null,
    /**
     * "F "
     */
    @SerializedName("https_rank")
    val httpsRank: String? = null,
    /**
     * 80
     */
    @SerializedName("obs_score")
    val obsScore: Long? = null,
    /**
     * "B+"
     */
    @SerializedName("obs_rank")
    val obsRank: String? = null,
    /**
     * "7"
     */
    @SerializedName("users")
    val usersCount: Long,
    /**
     * "16"
     */
    @SerializedName("statuses")
    val statusesCount: Long,
    /**
     * "386"
     */
    @SerializedName("connections")
    val connectionsCount: Long,
    /**
     * true
     */
    @SerializedName("open_registrations")
    val areRegistrationsOpen: Boolean,
    /**
     * See [InstanceInfo]
     */
    @SerializedName("info")
    val info: InstanceInfo? = null,
    /**
     * "https://mastodonsocial.nl/system/site_uploads/files/000/000/003/original/mastodonsocial3.png"
     */
    @SerializedName("thumbnail")
    val thumbnailUrl: String? = null,
    /**
     * "https://camo.instances.social/31116d821679b90a3b1c8cec5ecbb10e39f1edc2/68747470733a2f2f6d6173746f646f6e736f6369616c2e6e6c2f73797374656d2f736974655f75706c6f6164732f66696c65732f3030302f3030302f3030332f6f726967696e616c2f6d6173746f646f6e736f6369616c332e706e67"
     */
    @SerializedName("thumbnail_proxy")
    val thumbnailProxyUrl: String? = null,
    /**
     * 3
     */
    @SerializedName("active_users")
    val activeUsersCount: Long? = null,
    /**
     * "info@mastodonsocial.nl"
     */
    @SerializedName("email")
    val email: String? = null,
    /**
     * "admin"
     */
    @SerializedName("admin")
    val admin: String? = null,
)

data class InstancesPagination(
    @SerializedName("total")
    val total: Long,
    @SerializedName("next_id")
    val nextId: String? = null,
)

data class InstancesList(
    @SerializedName("instances")
    val instances: List<Instance>,
    @SerializedName("pagination")
    val pagination: InstancesPagination? = null,
)

interface InstancesSocialApi {
    /**
     * Get an instances sample (random pick)
     *
     * @param count Number of instances to get.
     * Default value: `20`
     * Size range: `1-100`
     * @param includeDead Include dead (down for at least two weeks) instances
     * Default value: `false`
     *
     * See https://instances.social/api/doc/#api-Instances-GetInstancesSample
     */
    @GET("api/1.0/instances/sample")
    suspend fun sample(
        @Query("count") count: Long? = null,
        @Query("include_dead") includeDead: Boolean? = null,
    ): InstancesList

    /**
     * List instances
     * @param count Number of instances to get. 0 returns all instances.
     * Default value: `20`
     * Size range: `0-10000`
     * @param includeDead Include dead (down for at least two weeks) instances
     * Default value: `false`
     * @param includeDown Include down instances
     * Default value: `true`
     * @param includeClosed Include instances with closed registrations
     * Default value: `true`
     * @param supportedFeatures Comma-separated list of features returned instances have to support
     * Allowed values: `"mstdn_custom_emojis"`
     * @param minVersion Minimal Mastodon version returned instances must be running. Format must be "a.b.c" (".b" and ".c" can be omitted) with a, b, c being integers.
     * @param minUsers Minimal users returned instances must have.
     * Size range: `0-`
     * @param maxUsers Maximal users returned instances must have.
     * Size range: `0-`
     * @param minActiveUsers Minimal active users per week returned instances must have. This will filter out instances running Mastodon versions older than 2.1.2.
     * Size range: `0-`
     * @param category Category instances must be in to be returned. Value _general_ will return instances in no category.
     * @param language Language instances must have as main language to be returned.
     * @param prohibitedContent Content returned instances must prohibit.
     * @param allowedContent Content returned instances must not prohibit.
     * @param minId Minimal ID of instances to retrieve. Use this to navigate through pages. The id of the first instance from next page is accessible through [InstancesPagination.nextId].
     * @param sortBy Field to sort instances by. By default, instances are not sorted and their order is not guaranteed to be consistent.
     * Allowed values: `"name"`, `"uptime"`, `"https_score"`, `"obs_score"`, `"users"`, `"statuses"`, `"connections"`, `"active_users"`
     * @param sortOrder Sort order, if [sortBy] is used.
     * Default value: `"asc"`
     * Allowed values: `"asc"`, `"desc"`
     */
    @GET("api/1.0/instances/list")
    suspend fun list(
        @Query("count") count: Number = 20,
        @Query("include_dead") includeDead: Boolean = false,
        @Query("include_down") includeDown: Boolean = true,
        @Query("include_closed") includeClosed: Boolean = true,
        @Query("supported_features") supportedFeatures: String = "mstdn_custom_emojis",
        @Query("min_version") minVersion: String? = null,
        @Query("min_users") minUsers: Number = 0,
        @Query("max_users") maxUsers: Number = 0,
        @Query("min_active_users") minActiveUsers: Number = 0,
        @Query("category") category: String = "general",
        @Query("language") language: String? = null,
        @Query("prohibited_content") prohibitedContent: List<String> = emptyList(),
        @Query("allowed_content") allowedContent: List<String> = emptyList(),
        @Query("min_id") minId: String? = null,
        @Query("sort_by") sortBy: String? = null,
        @Query("sort_order") sortOrder: String = "asc",
    ): InstancesList

    /**
     * Search instances
     *
     * @param q Query for searching through instance names, topics and descriptions.
     * @param count Number of instances to get. 0 returns all instances.
     * Default value: `20`
     * Size range: `0-10000`
     * @param inNameOnly Only search through names
     * Default value: `false`
     *
     * See https://instances.social/api/doc/#api-Instances-SearchInstances
     */
    @GET("api/1.0/instances/search")
    suspend fun search(
        @Query("q") q: String,
        @Query("count") count: Long = 20,
        @Query("name") inNameOnly: Boolean = false,
    ): InstancesList

    /**
     * Show instance information
     *
     * @param name Instance name.
     *
     * See https://instances.social/api/doc/#api-Instances-ShowInstance
     */
    @GET("api/1.0/instances/show")
    suspend fun show(
        @Query("name") name: String,
    ): Instance

}
