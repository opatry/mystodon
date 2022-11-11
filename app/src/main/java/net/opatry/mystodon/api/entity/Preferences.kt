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

enum class MediaVisibility {

    /**
     * Hide media marked as sensitive.
     */
    @SerializedName("default")
    Default,

    /**
     * Always show all media by default, regardless of sensitivity
     */
    @SerializedName("show_all")
    ShowAll,

    /**
     * Always hide all media by default, regardless of sensitivity
     */
    @SerializedName("hide_all")
    HideAll,
}

/**
 * Represents a user's preferences.
 */
data class Preferences(

    // region Attributes

    /**
     * Default visibility for new posts. Equivalent to [Source.defaultPrivacy].
     */
    @SerializedName("posting:default:visibility")
    val defaultVisibility: Visibility,

    /**
     * Default sensitivity flag for new posts. Equivalent to [Source.isSensitiveByDefault].
     */
    @SerializedName("posting:default:sensitive")
    val isSensitiveByDefault: Boolean,

    /**
     * Default language for new posts. Equivalent to [Source.defaultLanguage].
     * (ISO 639-1 language two-letter code), or `null`
     */
    @SerializedName("posting:default:language")
    val defaultLanguage: String? = null,

    /**
     * Whether media attachments should be automatically displayed or blurred/hidden.
     */
    @SerializedName("reading:expand:media")
    val defaultMediaVisibility: MediaVisibility,

    /**
     * Whether CWs should be expanded by default.
     */
    @SerializedName("reading:expand:spoilers")
    val areSpoilersExpandedByDefault: Boolean,

    // endregion
)
