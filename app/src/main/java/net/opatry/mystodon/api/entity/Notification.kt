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

enum class NotificationType {

    /**
     *Someone followed you
     */
    @SerializedName("follow")
    Follow,

    /**
     *Someone requested to follow you
     */
    @SerializedName("follow_request")
    FollowRequest,

    /**
     *Someone mentioned you in their status
     */
    @SerializedName("mention")
    Mention,

    /**
     *Someone boosted one of your statuses
     */
    @SerializedName("reblog")
    Reblog,

    /**
     *Someone favourited one of your statuses
     */
    @SerializedName("favourite")
    Favourite,

    /**
     *A poll you have voted in or created has ended
     */
    @SerializedName("poll")
    Poll,

    /**
     *Someone you enabled notifications for has posted a status
     */
    @SerializedName("status")
    Status,
}

/**
 * Represents a notification of an event relevant to the user.
 */
data class Notification(

    // region Required attributes

    /**
     * The id of the notification in the database.
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * The type of event that resulted in the notification.
     */
    @SerializedName("type")
    val type: NotificationType,

    /**
     * The timestamp of the notification.
     * (ISO 8601 Datetime)
     */
    @SerializedName("created_at")
    val createdAt: String,

    /**
     * The account that performed the action that generated the notification.
     */
    @SerializedName("account")
    val fromAccount: Account,

    // endregion

    // region Optional attributes

    /**
     * Status that was the object of the notification, e.g. in [NotificationType.Mention]s, [NotificationType.Reblog]s, [NotificationType.Favourite]s, or [[NotificationType.Poll]s.
     */
    @SerializedName("status")
    val status: Status? = null,

    // endregion
)
