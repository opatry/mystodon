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
 * Represents an emoji reaction to an Announcement.
 */
data class AnnouncementReaction(

    // region Base attributes

    /**
     * The emoji used for the reaction. Either a unicode emoji, or a custom emoji's shortcode.
     */
    @SerializedName("name")
    val name: String,

    /**
     * The total number of users who have added this reaction.
     */
    @SerializedName("count")
    val count: Long,

    /**
     * Whether the authorized user has added this reaction to the announcement.
     */
    @SerializedName("me")
    val isMe: Boolean,

    // endregion

    // region Custom emoji attributes

    /**
     * A link to the custom emoji.
     * (URL)
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * A link to a non-animated version of the custom emoji.
     * (URL)
     */
    @SerializedName("static_url")
    val staticUrl: String? = null,

    // endregion
)
