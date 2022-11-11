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

data class MarkerData(

    /**
     * The ID of the most recently viewed entity.
     * (cast from integer but not guaranteed to be a number)
     */
    @SerializedName("last_read_id")
    val lastReadId: String,

    /**
     * The timestamp of when the marker was set.
     * (ISO 8601 Datetime)
     */
    @SerializedName("updated_at")
    val updatedAt: String,

    /**
     * Used for locking to prevent write conflicts.
     */
    @SerializedName("version")
    val version: Long,
)

/**
 * Represents the last read position within a user's timelines.
 */
data class Marker(

    // region Base attributes

    /**
     * Information about the user's position in the home timeline.
     */
    @SerializedName("home")
    val home: MarkerData,

    /**
     * Information about the user's position in their notifications.
     */
    @SerializedName("notifications")
    val notifications: MarkerData,

    // endregion
)
