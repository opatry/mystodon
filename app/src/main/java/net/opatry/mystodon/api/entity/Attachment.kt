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

enum class AttachmentType {
    /**
     * Unsupported or unrecognized file type
     */
    @SerializedName("unknown")
    Unknown,

    /**
     * Static image
     */
    @SerializedName("image")
    Image,

    /**
     * Looping, soundless animation
     */
    @SerializedName("gifv")
    GIFV,

    /**
     * Video clip
     */
    @SerializedName("video")
    Video,

    /**
     * Audio track
     */
    @SerializedName("audio")
    Audio,
}

/**
 * Represents a file or media attachment that can be added to a status.
 */
data class Attachment(

    // region Required attributes

    /**
     * The ID of the attachment in the database.
     * (cast from an integer but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * The type of the attachment.
     */
    @SerializedName("type")
    val type: AttachmentType,

    /**
     * The location of the original full-size attachment.
     * (URL)
     */
    @SerializedName("url")
    val url: String,

    /**
     * The location of a scaled-down preview of the attachment.
     * (URL)
     */
    @SerializedName("preview_url")
    val previewUrl: String,

    // endregion

    // region Optional attributes

    /**
     * The location of the full-size original attachment on the remote website.
     * (URL), or null if the attachment is local
     */
    @SerializedName("remote_url")
    val remoteUrl: String? = null,

    /**
     * Metadata returned by Paperclip.
     * May contain subtrees `small` and `original`, as well as various other top-level properties.
     */
    @SerializedName("meta")
    val meta: Any? = null,

    /**
     * Alternate text that describes what is in the media attachment, to be used for the visually impaired or when media attachments do not load.
     */
    @SerializedName("description")
    val description: String? = null,

    /**
     */
    @SerializedName("blurhash")
    val blurHash: String? = null,

    // endregion

    // region Deprecated attributes

    /**
     * A shorter URL for the attachment.
     * (URL)
     */
    @SerializedName("text_url")
    val textUrl: String? = null,

    // endregion
)
