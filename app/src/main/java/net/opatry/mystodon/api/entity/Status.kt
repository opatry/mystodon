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
import kotlin.collections.List

/**
 * Represents a status posted by an account.
 */
data class Status(

    // region Base attributes

    /**
     * ID of the status in the database.
     * (cast from an integer but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * URI of the status used for federation.
     */
    @SerializedName("uri")
    val uri: String,

    /**
     * The date when this status was created.
     * (ISO 8601 Datetime)
     */
    @SerializedName("created_at")
    val createdAt: String,

    /**
     * The account that authored this status.
     */
    @SerializedName("account")
    val account: Account,

    /**
     * HTML-encoded status content.
     * (HTML)
     */
    @SerializedName("content")
    val content: String,

    /**
     * Visibility of this status.
     */
    @SerializedName("visibility")
    val visibility: Visibility,

    /**
     * Is this status marked as sensitive content?
     */
    @SerializedName("sensitive")
    val isSensitive: Boolean,

    /**
     * Subject or summary line, below which status content is collapsed until expanded.
     */
    @SerializedName("spoiler_text")
    val spoilerText: String,

    /**
     * Media that is attached to this status.
     */
    @SerializedName("media_attachments")
    val mediaAttachments: List<Attachment>,

    /**
     * The application used to post this status.
     */
    @SerializedName("application")
    val application: Application,

    // endregion

    // region Rendering attributes

    /**
     * Mentions of users within the status content.
     */
    @SerializedName("mentions")
    val mentions: List<Mention>,

    /**
     * Hashtags used within the status content.
     */
    @SerializedName("tags")
    val tags: List<Tag>,

    /**
     * Custom emoji to be used when rendering status content.
     */
    @SerializedName("emojis")
    val emojis: List<Emoji>,

    // endregion

    // region Informational attributes

    /**
     * How many boosts this status has received.
     */
    @SerializedName("reblogs_count")
    val reblogsCount: Long,

    /**
     * How many favourites this status has received.
     */
    @SerializedName("favourites_count")
    val favouritesCount: Long,

    /**
     * How many replies this status has received.
     */
    @SerializedName("replies_count")
    val repliesCount: Long,

    // endregion

    // region Nullable attributes

    /**
     * A link to the status's HTML representation.
     * (URL)
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * ID of the status being replied.
     * (cast from an integer but not guaranteed to be a number)
     */
    @SerializedName("in_reply_to_id")
    val inReplyToId: String? = null,

    /**
     * ID of the account being replied to.
     * (cast from an integer but not guaranteed to be a number)
     */
    @SerializedName("in_reply_to_account_id")
    val inReplyToAccountId: String? = null,

    /**
     * The status being reblogged.
     */
    @SerializedName("reblog")
    val reblog: Status? = null,

    /**
     * The poll attached to the status.
     */
    @SerializedName("poll")
    val poll: Poll? = null,

    /**
     * Preview card for links included within status content.
     */
    @SerializedName("card")
    val card: Card? = null,

    /**
     * Primary language of this status.
     */
    @SerializedName("language")
    val language: String? = null,

    /**
     */
    @SerializedName("text")
    val text: String? = null,

    // endregion

    // region Authorized user attributes

    /**
     * Have you favourited this status?
     */
    @SerializedName("favourited")
    val isFavourited: Boolean? = null,

    /**
     * Have you boosted this status?
     */
    @SerializedName("reblogged")
    val isReblogged: Boolean? = null,

    /**
     * Have you muted notifications for this status's conversation?
     */
    @SerializedName("muted")
    val isMuted: Boolean? = null,

    /**
     * Have you bookmarked this status?
     */
    @SerializedName("bookmarked")
    val isBookmarked: Boolean? = null,

    /**
     * Have you pinned this status? Only appears if the status is pinnable.
     */
    @SerializedName("pinned")
    val isPinned: Boolean? = null,

    // endregion
)
