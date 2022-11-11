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
 * Admin-level information about a given account.
 */
data class AdminAccount(

    // region Attributes

    /**
     * The ID of the account in the database.
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("id")
    val id: String,

    /**
     * The username of the account.
     */
    @SerializedName("username")
    val username: String,

    /**
     * The domain of the account.
     */
    @SerializedName("domain")
    val domain: String,

    /**
     * When the account was first discovered.
     * (ISO 8601 Datetime)
     */
    @SerializedName("created_at")
    val createdAt: String,

    /**
     * The email address associated with the account.
     */
    @SerializedName("email")
    val email: String,

    /**
     * The IP address last used to login to this account.
     */
    @SerializedName("ip")
    val ip: String,

    /**
     * The locale of the account.
     * (ISO 639 Part 1 two-letter language code)
     */
    @SerializedName("locale")
    val locale: String,

    /**
     * Invite request text ???
     */
    @SerializedName("invite_request")
    val inviteRequest: String,

    // endregion

    // region State attributes

    /**
     * The current role of the account.
     * (Enumerable oneOf)
     */
    @SerializedName("role")
    val role: String,

    /**
     * Whether the account has confirmed their email address.
     */
    @SerializedName("confirmed")
    val isConfirmed: Boolean,

    /**
     * Whether the account is currently approved.
     */
    @SerializedName("approved")
    val isApproved: Boolean,

    /**
     * Whether the account is currently disabled.
     */
    @SerializedName("disabled")
    val isDisabled: Boolean,

    /**
     * Whether the account is currently silenced.
     */
    @SerializedName("silenced")
    val isSilenced: Boolean,

    /**
     * Whether the account is currently suspended.
     */
    @SerializedName("suspended")
    val isSuspended: Boolean,

    /**
     * User-level information about the account.
     */
    @SerializedName("account")
    val account: Account,

    // endregion

    // region Nullable attributes

    /**
     * The ID of the application that created this account.
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("created_by_application_id")
    val createdByApplicationId: String? = null,

    /**
     * The ID of the account that invited this user
     * (cast from an integer, but not guaranteed to be a number)
     */
    @SerializedName("invited_by_account_id")
    val invitedByAccountId: String? = null,

    // endregion
)
