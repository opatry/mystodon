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
 * Represents a rich preview card that is generated using OpenGraph tags from a URL.
 */
data class Card(

    // region Base attributes

    /**
     * Location of linked resource.
     * (URL)
     */
    @SerializedName("url")
    val url: String,

    /**
     * Title of linked resource.
     */
    @SerializedName("title")
    val title: String,

    /**
     * Description of preview.
     */
    @SerializedName("description")
    val description: String,

    /**
     * The type of the preview card.
     */
    @SerializedName("type")
    val type: String, /*(Enumerable, oneOf)*/ // TODO enum

    // endregion

    // region Optional attributes

    /**
     * The author of the original resource.
     */
    @SerializedName("author_name")
    val authorName: String? = null,

    /**
     * A link to the author of the original resource.
     * (URL)
     */
    @SerializedName("author_url")
    val authorUrl: String? = null,

    /**
     * The provider of the original resource.
     */
    @SerializedName("provider_name")
    val providerName: String? = null,

    /**
     * A link to the provider of the original resource.
     * (URL)
     */
    @SerializedName("provider_url")
    val providerUrl: String? = null,

    /**
     * HTML to be used for generating the preview card.
     * (HTML)
     */
    @SerializedName("html")
    val html: String? = null,

    /**
     * Width of preview, in pixels.
     */
    @SerializedName("width")
    val width: Long? = null,

    /**
     * Height of preview, in pixels.
     */
    @SerializedName("height")
    val height: Long? = null,

    /**
     * Preview thumbnail.
     * (URL)
     */
    @SerializedName("image")
    val imageUrl: String? = null,

    /**
     * Used for photo embeds, instead of custom [html].
     * (URL)
     */
    @SerializedName("embed_url")
    val embedUrl: String? = null,

    /**
     * A hash computed by the [BlurHash](https://github.com/woltapp/blurhash) algorithm, for generating colorful preview thumbnails when media has not been downloaded yet.
     */
    @SerializedName("blurhash")
    val blurHash: String? = null,

    // endregion
)
