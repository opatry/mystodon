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

/**
 * Represents the relationship between accounts, such as following / blocking / muting / etc.
 */
data class Relationship(

    // region Required attributes

    /**
     * The account id.
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * Are you following this user?
     */
    @SerializedName("following")
    val isFollowing: Boolean,

    /**
     * Do you have a pending follow request for this user?
     */
    @SerializedName("requested")
    val isRequested: Boolean,

    /**
     * Are you featuring this user on your profile?
     */
    @SerializedName("endorsed")
    val isEndorsed: Boolean,

    /**
     * Are you followed by this user?
     */
    @SerializedName("followed_by")
    val isFollowedBy: Boolean,

    /**
     * Are you muting this user?
     */
    @SerializedName("muting")
    val isMuting: Boolean,

    /**
     * Are you muting notifications from this user?
     */
    @SerializedName("muting_notifications")
    val isMutingNotifications: Boolean,

    /**
     * Are you receiving this user's boosts in your home timeline?
     */
    @SerializedName("showing_reblogs")
    val isShowingReblogs: Boolean,

    /**
     * Have you enabled notifications for this user?
     */
    @SerializedName("notifying")
    val isNotifying: Boolean,

    /**
     * Are you blocking this user?
     */
    @SerializedName("blocking")
    val isBlocking: Boolean,

    /**
     * Are you blocking this user's domain?
     */
    @SerializedName("domain_blocking")
    val isDomainBlocking: Boolean,

    /**
     * Is this user blocking you?
     */
    @SerializedName("blocked_by")
    val isBlockedBy: Boolean,

    /**
     * This user's profile bio
     */
    @SerializedName("note")
    val note: String,

    // endregion
)
