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

enum class FilterContext {

    /**
     * Home timeline and lists.
     */
    @SerializedName("home")
    Home,

    /**
     * Notifications timeline.
     */
    @SerializedName("notifications")
    Notifications,

    /**
     * Public timelines.
     */
    @SerializedName("public")
    Public,

    /**
     * Expanded thread of a detailed status.
     */
    @SerializedName("thread")
    Thread,
}

/**
 * Represents a user-defined filter for determining which statuses should not be shown to the user.
 */
data class Filter(

    // region Attributes

    /**
     * The ID of the filter in the database.
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * The text to be filtered.
     */
    @SerializedName("phrase")
    val phrase: String,

    /**
     * The contexts in which the filter should be applied.
     */
    @SerializedName("context")
    val context: List<FilterContext>,

    /**
     * When the filter should no longer be applied
     * (ISO 8601 Datetime), or null if the filter does not expire
     */
    @SerializedName("expires_at")
    val expiresAt: String,

    /**
     * Should matching entities in home and notifications be dropped by the server?
     */
    @SerializedName("irreversible")
    val isIrreversible: Boolean,

    /**
     * Should the filter consider word boundaries?
     */
    @SerializedName("whole_word")
    val isWholeWord: Boolean,

    // endregion
)
