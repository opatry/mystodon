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
 * Represents an announcement set by an administrator.
 */
data class Announcement(

    // region Base attributes

    /**
     * The announcement id.
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * The content of the announcement.
     */
    @SerializedName("text")
    val text: String,

    /**
     * Whether the announcement is currently active.
     */
    @SerializedName("published")
    val isPublished: Boolean,

    /**
     * Whether the announcement has a start/end time.
     */
    @SerializedName("all_day")
    val isAllDay: Boolean,

    /**
     * When the announcement was created.
     * (ISO 8601 Datetime)
     */
    @SerializedName("created_at")
    val createdAt: String,

    /**
     * When the announcement was last updated.
     * (ISO 8601 Datetime)
     */
    @SerializedName("updated_at")
    val updatedAt: String,

    /**
     * Whether the announcement has been read by the user.
     */
    @SerializedName("read")
    val isRead: Boolean,

    /**
     * Emoji reactions attached to the announcement.
     */
    @SerializedName("reactions")
    val reactions: List<AnnouncementReaction>,

    // endregion

    // region Optional attributes

    /**
     * When the future announcement was scheduled.
     * (ISO 8601 Datetime)
     */
    @SerializedName("scheduled_at")
    val scheduledAt: String? = null,

    /**
     * When the future announcement will start.
     * (ISO 8601 Datetime)
     */
    @SerializedName("starts_at")
    val startsAt: String? = null,

    /**
     * When the future announcement will end.
     * (ISO 8601 Datetime)
     */
    @SerializedName("ends_at")
    val endsAt: String? = null,

    // endregion
)
