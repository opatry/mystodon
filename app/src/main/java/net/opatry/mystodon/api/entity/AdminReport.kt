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
 * Admin-level information about a filed report.
 */
data class AdminReport(

    // region Attributes

    /**
     * The ID of the report in the database.
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * The action taken to resolve this report.
     * (Enumerable oneOf)
     */
    @SerializedName("action_taken")
    val actionTaken: String,

    /**
     * An optional reason for reporting.
     */
    @SerializedName("comment")
    val comment: String,

    /**
     * The time the report was filed.
     * (ISO 8601 Datetime)
     */
    @SerializedName("created_at")
    val createdAt: String,

    /**
     * The time of last action on this report.
     * (ISO 8601 Datetime)
     */
    @SerializedName("updated_at")
    val updatedAt: String,

    /**
     * The account which filed the report.
     */
    @SerializedName("account")
    val account: Account,

    /**
     * The account being reported.
     */
    @SerializedName("target_account")
    val targetAccount: Account,

    /**
     * The account of the moderator assigned to this report.
     */
    @SerializedName("assigned_account")
    val assignedAccount: Account,

    /**
     * The action taken by the moderator who handled the report.
     * (Enumerable oneOf)
     */
    @SerializedName("action_taken_by_account")
    val actionTakenByAccount: String,

    /**
     * Statuses attached to the report, for context.
     */
    @SerializedName("statuses")
    val statuses: List<Status>,

    // endregion
)
