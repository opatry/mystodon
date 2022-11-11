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

data class PollOptions(

    /**
     * The text value of the poll option.
     */
    @SerializedName("title")
    val title: String,

    /**
     * The number of received votes for this option.
     * Number, or null if results are not published yet.
     */
    @SerializedName("votes_count")
    val votesCount: Long? = null,
)

/**
 * Represents a poll attached to a status.
 */
data class Poll(

    // region Attributes

    /**
     * The ID of the poll in the database.
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * When the poll ends.
     * (ISO 8601 Datetime), or `null` if the poll does not end
     */
    @SerializedName("expires_at")
    val expiresAt: String,

    /**
     * Is the poll currently expired?
     */
    @SerializedName("expired")
    val isExpired: Boolean,

    /**
     * Does the poll allow multiple-choice answers?
     */
    @SerializedName("multiple")
    val isMultiple: Boolean,

    /**
     * How many votes have been received.
     */
    @SerializedName("votes_count")
    val votesCount: Long,

    /**
     * How many unique accounts have voted on a multiple-choice poll.
     * Number or `null` if [isMultiple] is false.
     */
    @SerializedName("voters_count")
    val votersCount: Long? = null,

    /**
     * When called with a user token, has the authorized user voted?
     * Boolean or `null` if no current user
     */
    @SerializedName("voted")
    val hasVoted: Boolean? = null,

    /**
     * When called with a user token, which options has the authorized user chosen? Contains an array of index values for [options].
     * Array of Number, or `null` if no current user
     */
    @SerializedName("own_votes")
    val ownVotes: List<Int>? = null,

    /**
     * Possible answers for the poll.
     */
    @SerializedName("options")
    val options: List<PollOptions>,

    /**
     * Custom emoji to be used for rendering poll options.
     */
    @SerializedName("emojis")
    val emojis: List<Emoji>,

    // endregion
)
