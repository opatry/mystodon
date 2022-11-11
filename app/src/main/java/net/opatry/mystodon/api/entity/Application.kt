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
 * Represents an application that interfaces with the REST API to access accounts or post statuses.
 */
data class Application(

    // region Required attributes

    /**
     * The name of your application.
     */
    @SerializedName("name")
    val name: String,

    // endregion

    // region Optional attributes

    /**
     * The website associated with your application.
     * (URL)
     */
    @SerializedName("website")
    val websiteUrl: String? = null,

    /**
     * Used for Push Streaming API. Returned with [`POST /api/v1/apps`](https://docs.joinmastodon.org/methods/apps/#create-an-application).
     * Equivalent to [PushSubscription.serverKey].
     */
    @SerializedName("vapid_key")
    val vapidKey: String? = null,

    // endregion

    // region Client attributes

    /**
     * Client ID key, to be used for obtaining OAuth tokens
     */
    @SerializedName("client_id")
    val clientId: String? = null,

    /**
     * Client secret key, to be used for obtaining OAuth tokens
     */
    @SerializedName("client_secret")
    val clientSecret: String? = null,

    // endregion
)
