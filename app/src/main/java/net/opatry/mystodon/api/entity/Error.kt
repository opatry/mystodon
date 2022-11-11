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
 * Represents an error message.
 */
data class Error(

    // region Required attributes

    /**
     * The error message.
     */
    @SerializedName("error")
    val error: String,

    // endregion

    // region Optional attributes

    /**
     * A longer description of the error, mainly provided with the OAuth API.
     */
    @SerializedName("error_description")
    val errorDescription: String? = null,

    // endregion
)

// region Possible reasons

val RequireAuthenticatedUser401: Error = Error(
    "require_authenticated_user!",
    "Error: This API requires an authenticated user. Appears when the instance is in secure mode, which disables all public use of API methods."
)

val CurrentUserDisabled403: Error = Error(
    "current_user.disabled?",
    "Your login is currently disabled. Appears when the OAuth token's authorized user has had their account disabled by a moderator."
)

val CurrentUserNotConfirmed403: Error = Error(
    "!current_user.confirmed?",
    "Error: Your login is missing a confirmed e-mail address. Appears when the email address associated with the OAuth token's authorized user's account has not yet been confirmed."
)

val CurrentUserNotApproved403: Error = Error(
    "!current_user.approved?",
    "Error: Your login is currently pending approval. Appears when the OAuth token's authorized user has signed up on an instance with approval-required registrations, and the user has not yet had their account approved by a moderator."
)

val RecordNotFound404: Error = Error(
    "RecordNotFound",
    "Error: Record not found. Appears when an entity record does not exist, or the authorized user is not within the audience of a private entity.operates on a user."
)

val RecordInvalid422: Error = Error(
    "RecordInvalid",
    "Error: {string}. May appear when entity creation failed."
)

val RecordNotUnique422: Error = Error(
    "RecordNotUnique",
    "Error: Duplicate record. Appears when you are trying to pin an account or status that is already pinned."
)

val NotCurrentUser422: Error = Error(
    "!current_user",
    "Error: This method requires an authenticated user. Appears when using an OAuth token without an authorized user (or no token at all), while trying to call an API method that requires a user to be processed."
)

// endregion
