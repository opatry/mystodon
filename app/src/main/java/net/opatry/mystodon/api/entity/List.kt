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

enum class ReplyPolicy {

    /**
     * Show replies to any followed user.
     */
    @SerializedName("followed")
    Followed,

    /**
     * Show replies to members of the list.
     */
    @SerializedName("list")
    List,

    /**
     * Show replies to no one.
     */
    @SerializedName("none")
    None,
}

/**
 * Represents a list of some users that the authenticated user follows.
 */
data class List(

    // region Required attributes

    /**
     * The internal database ID of the list.
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * The user-defined title of the list.
     */
    @SerializedName("title")
    val title: String,

    /**
     * The user-defined title of the list.
     */
    @SerializedName("replies_policy")
    val repliesPolicy: ReplyPolicy,

    // endregion
)
