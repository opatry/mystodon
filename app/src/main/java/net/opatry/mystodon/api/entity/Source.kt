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
 * Represents display or publishing preferences of user's own account. Returned as an additional entity when verifying and updated credentials, as an attribute of [Account].
 */
data class Source(

    // region Base attributes

    /**
     * Profile bio.
     */
    @SerializedName("note")
    val note: String,

    /**
     * Metadata about the account.
     */
    @SerializedName("fields")
    val fields: List<Field>,

    // endregion

    // region Nullable attributes

    /**
     * The default post privacy to be used for new statuses.
     */
    @SerializedName("privacy")
    val defaultPrivacy: Visibility? = null,

    /**
     * Whether new statuses should be marked sensitive by default.
     */
    @SerializedName("sensitive")
    val isSensitiveByDefault: Boolean? = null,

    /**
     * The default posting language for new statuses.
     * (ISO 639-1 language two-letter code)
     */
    @SerializedName("language")
    val defaultLanguage: String? = null,

    /**
     * The number of pending follow requests.
     */
    @SerializedName("follow_requests_count")
    val followRequestsCount: Long? = null,

    // endregion
)
