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

package net.opatry.mystodon.api.entity

import com.google.gson.annotations.SerializedName
import kotlin.collections.List

data class InstanceStats(

    /**
     * Users registered on this instance.
     */
    @SerializedName("user_count")
    val userCount: Long,

    /**
     * Statuses authored by users on instance.
     */
    @SerializedName("status_count")
    val statusCount: Long,

    /**
     * Domains federated with this instance.
     */
    @SerializedName("domain_count")
    val domainCount: Long,
)

data class InstanceUrl(

    /**
     * Websockets address for push streaming.
     * (URL)
     */
    @SerializedName("streaming_api")
    val streamingApiUrl: String,
)

/**
 * Represents the software instance of Mastodon running on this domain.
 */
data class Instance(

    // region Required attributes

    /**
     * The domain name of the instance.
     */
    @SerializedName("uri")
    val uri: String,

    /**
     * The title of the website.
     */
    @SerializedName("title")
    val title: String,

    /**
     * Admin-defined description of the Mastodon site.
     */
    @SerializedName("description")
    val description: String,

    /**
     * A shorter description defined by the admin.
     */
    @SerializedName("short_description")
    val shortDescription: String,

    /**
     * An email that may be contacted for any inquiries.
     */
    @SerializedName("email")
    val email: String,

    /**
     * The version of Mastodon installed on the instance.
     */
    @SerializedName("version")
    val version: String,

    /**
     * Primary languages of the website and its staff.
     * (ISO 639 Part 1-5 language codes)
     */
    @SerializedName("languages")
    val languages: List<String>,

    /**
     * Whether registrations are enabled.
     */
    @SerializedName("registrations")
    val areRegistrationsEnabled: Boolean,

    /**
     * Whether registrations require moderator approval.
     */
    @SerializedName("approval_required")
    val isApprovalRequired: Boolean,

    /**
     * Whether invites are enabled.
     */
    @SerializedName("invites_enabled")
    val areInvitesEnabled: Boolean,

    /**
     * URLs of interest for clients apps.
     */
    @SerializedName("urls")
    val urls: InstanceUrl,

    /**
     * Statistics about how much information the instance contains.
     */
    @SerializedName("stats")
    val stats: InstanceStats,

    // endregion

    // region Optional attributes

    /**
     * Banner image for the website.
     * (URL)
     */
    @SerializedName("thumbnail")
    val thumbnailUrl: String? = null,

    /**
     * A user that can be contacted, as an alternative to `email`.
     */
    @SerializedName("contact_account")
    val contactAccount: Account? = null,

    // endregion
)
