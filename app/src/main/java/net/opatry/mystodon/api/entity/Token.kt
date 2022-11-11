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
 * Represents an OAuth token used for authenticating with the API and performing actions.
 */
data class Token(

    // region Attributes

    /**
     * An OAuth token to be used for authorization.
     */
    @SerializedName("access_token")
    val accessToken: String,

    /**
     * The OAuth token type. Mastodon uses `Bearer` tokens.
     */
    @SerializedName("token_type")
    val tokenType: String,

    /**
     * The OAuth scopes granted by this token, space-separated.
     */
    @SerializedName("scope")
    val scope: String,

    /**
     * When the token was generated.
     * (UNIX Timestamp)
     */
    @SerializedName("created_at")
    val createdAt: Long,

    // endregion
) {
    val authorization: String
        get() = "$tokenType $accessToken"
}
