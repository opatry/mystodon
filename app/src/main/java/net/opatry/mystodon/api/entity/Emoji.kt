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
 * Represents a custom emoji.
 */
data class Emoji(

    // region Required attributes

    /**
     * The name of the custom emoji.
     */
    @SerializedName("shortcode")
    val shortCode: String,

    /**
     * A link to the custom emoji.
     * (URL)
     */
    @SerializedName("url")
    val url: String,

    /**
     * A link to a static copy of the custom emoji.
     * (URL)
     */
    @SerializedName("static_url")
    val staticUrl: String,

    /**
     * Whether this Emoji should be visible in the picker or unlisted.
     */
    @SerializedName("visible_in_picker")
    val isVisibleInPicker: Boolean,

    // endregion

    // region Optional attributes

    /**
     * Used for sorting custom emoji in the picker.
     */
    @SerializedName("category")
    val category: String? = null,

    // endregion
)
