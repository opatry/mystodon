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
 * Represents a proof from an external identity provider.
 */
data class IdentityProof(

    // region Attributes

    /**
     * The name of the identity provider.
     */
    @SerializedName("provider")
    val provider: String,

    /**
     * The account owner's username on the identity provider's service.
     */
    @SerializedName("provider_username")
    val providerUsername: String,

    /**
     * The account owner's profile URL on the identity provider.
     * (URL)
     */
    @SerializedName("profile_url")
    val profileUrl: String,

    /**
     * A link to a statement of identity proof, hosted by the identity provider.
     * (URL)
     */
    @SerializedName("proof_url")
    val proofUrl: String,

    /**
     * When the identity proof was last updated.
     * (ISO 8601 Datetime)
     */
    @SerializedName("updated_at")
    val updatedAt: String,

    // endregion
)
