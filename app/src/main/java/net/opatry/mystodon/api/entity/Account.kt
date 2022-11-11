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

/**
 * Represents a user of Mastodon and their associated profile.
 */
data class Account(

    // region Base attributes

    /**
     * The account id `header`.
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * The username of the account, not including domain.
     */
    @SerializedName("username")
    val username: String,

    /**
     * The WebFinger account URI. Equal to [username] for local users, or `username@domain` for remote users.
     */
    @SerializedName("acct")
    val acct: String,

    /**
     * The location of the user's profile page.
     * (HTTPS URL)
     */
    @SerializedName("url")
    val url: String,

    // endregion

    // region Display attributes

    /**
     * The profile's display name.
     */
    @SerializedName("display_name")
    val displayName: String,

    /**
     * The profile's bio / description.
     * (HTML)
     */
    @SerializedName("note")
    val note: String,

    /**
     * An image icon that is shown next to statuses and in the profile.
     * (URL)
     */
    @SerializedName("avatar")
    val avatarUrl: String,

    /**
     * A static version of the avatar. Equal to [avatarUrl] if its value is a static image; different if [avatarUrl] is an animated GIF.
     * (URL)
     */
    @SerializedName("avatar_static")
    val avatarStaticUrl: String,

    /**
     * An image banner that is shown above the profile and in profile cards.
     * (URL)
     */
    @SerializedName("header")
    val headerUrl: String,

    /**
     * A static version of the header. Equal to [headerUrl] if its value is a static image; different if [headerUrl] is an animated GIF.
     * (URL)
     */
    @SerializedName("header_static")
    val headerStaticUrl: String,

    /**
     * Whether the account manually approves follow requests.
     */
    @SerializedName("locked")
    val isLocked: Boolean,

    /**
     * Custom emoji entities to be used when rendering the profile. If none, an empty array will be returned.
     */
    @SerializedName("emojis")
    val emojis: List<Emoji>,

    /**
     * Whether the account has opted into discovery features such as the profile directory.
     */
    @SerializedName("discoverable")
    val isDiscoverable: Boolean? = null,

    // endregion

    // region Statistical attributes

    /**
     * When the account was created.
     * (ISO 8601 Datetime)
     */
    @SerializedName("created_at")
    val createdAt: String,

    /**
     * When the most recent status was posted.
     * (ISO 8601 Datetime)
     */
    @SerializedName("last_status_at")
    val lastStatusAt: String,

    /**
     * How many statuses are attached to this account.
     */
    @SerializedName("statuses_count")
    val statusesCount: Long,

    /**
     * The reported followers of this profile.
     */
    @SerializedName("followers_count")
    val followersCount: Long,

    /**
     * The reported follows of this profile.
     */
    @SerializedName("following_count")
    val followingCount: Long,

    // endregion

    // region Optional attributes

    /**
     * Indicates that the profile is currently inactive and that its user has moved to a new account.
     */
    @SerializedName("moved")
    val movedTo: Account? = null,

    /**
     * Additional metadata attached to a profile as name-value pairs.
     */
    @SerializedName("fields")
    val fields: List<Field>? = null,

    /**
     * A presentational flag. Indicates that the account may perform automated actions, may not be monitored, or identifies as a robot.
     */
    @SerializedName("bot")
    val isBot: Boolean? = null,

    /**
     * An extra entity to be used with API methods to [verify credentials](https://docs.joinmastodon.org/methods/accounts/#verify-account-credentials) and [update credentials](https://docs.joinmastodon.org/methods/accounts/#update-account-credentials).
     */
    @SerializedName("source")
    val source: Source? = null,

    /**
     * An extra entity returned when an account is suspended.
     */
    @SerializedName("suspended")
    val isSuspended: Boolean? = null,

    /**
     * When a timed mute will expire, if applicable.
     * (ISO 8601 Datetime)
     */
    @SerializedName("mute_expires_at")
    val muteExpiresAt: String? = null,

    // endregion
)
