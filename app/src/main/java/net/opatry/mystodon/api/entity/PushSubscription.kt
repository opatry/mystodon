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

data class Alerts(

    /**
     * Receive a push notification when someone has followed you?
     */
    @SerializedName("follow")
    val isFollow: Boolean,

    /**
     * Receive a push notification when a status you created has been favourited by someone else?
     */
    @SerializedName("favourite")
    val isFavourite: Boolean,

    /**
     * Receive a push notification when someone else has mentioned you in a status?
     */
    @SerializedName("mention")
    val isMention: Boolean,

    /**
     * Receive a push notification when a status you created has been boosted by someone else?
     */
    @SerializedName("reblog")
    val isReblog: Boolean,

    /**
     * Receive a push notification when a poll you voted in or created has ended?
     */
    @SerializedName("poll")
    val isPoll: Boolean
)

/**
 * Represents a subscription to the push streaming server.
 */
data class PushSubscription(

    // region Required attributes

    /**
     * The id of the push subscription in the database.
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * Where push alerts will be sent to.
     * (URL)
     */
    @SerializedName("endpoint")
    val endpointUrl: String,

    /**
     * The streaming server's VAPID key.
     */
    @SerializedName("server_key")
    val serverKey: String,

    /**
     * Which alerts should be delivered to the [endpointUrl].
     */
    @SerializedName("alerts")
    val alerts: Alerts,

    // endregion
)
