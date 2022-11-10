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

package net.opatry.mystodon.api

import android.net.Uri
import com.google.gson.annotations.SerializedName
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

sealed class Entity {
    data class Application(
        // Required attributes

        /**
         * The name of your application.
         */
        @SerializedName("name")
        val name: String,

        // Optional attributes
        /**
         * The website associated with your application.
         */
        @SerializedName("website")
        val website: String?,
        /**
         * Used for Push Streaming API. Returned with
         * [`POST /api/v1/apps`](https://docs.joinmastodon.org/methods/apps/#create-an-application). Equivalent to
         * [PushSubscription#server_key](https://docs.joinmastodon.org/entities/pushsubscription/#server_key)
         */
        @SerializedName("vapidKey")
        val vapidKey: String,

        // Client attributes

        /**
         * Client ID key, to be used for obtaining OAuth tokens
         */
        @SerializedName("client_id")
        val clientId: String,
        /**
         * Client secret key, to be used for obtaining OAuth tokens
         */
        @SerializedName("client_secret")
        val clientSecret: String,
    )
}

fun mastodonAuthorizeUri(
    instanceAuthority: String,
    clientId: String,
    redirectUri: String,
    scope: String
): Uri = Uri.Builder()
    .scheme("https")
    .authority(instanceAuthority)
    .path("/oauth/authorize")
    .appendQueryParameter("response_type", "code")
    .appendQueryParameter("client_id", clientId)
    .appendQueryParameter("redirect_uri", redirectUri)
    .appendQueryParameter("scope", scope)
    .build()

interface MastodonApi {

    /**
     * Create a new application to obtain OAuth2 credentials.
     *
     * @param clientName A name for your application
     * @param redirectUris Where the user should be redirected after authorization. To display the authorization code to
     * the user instead of redirecting to a web page, use `urn:ietf:wg:oauth:2.0:oob` in this
     * parameter.
     * @param scopes Space separated list of scopes. If none is provided, defaults to `read`.
     * @param website A URL to the homepage of your app
     * @return [Entity.Application], with `client_id` and `client_secret`
     *
     * See https://docs.joinmastodon.org/methods/apps/
     */
    @FormUrlEncoded
    @POST("api/v1/apps")
    suspend fun getApp(
        @Field("client_name") clientName: String,
        @Field("redirect_uris") redirectUris: String,
        @Field("scopes") scopes: String = "read",
        @Field("website") website: String? = null
    ): Entity.Application

    /**
     * Confirm that the app's OAuth2 credentials work.
     *
     * @return If the Authorization header was provided with a valid token, you should see your app returned as an
     * [Entity.Application] entity.
     *
     * https://docs.joinmastodon.org/methods/apps/
     */
    @GET("api/v1/apps/verify_credentials")
    suspend fun verifyCredentials(@Header("Authorization") bearerToken: String): Entity.Application

}
