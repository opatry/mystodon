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

    data class Token(
        /**
         * An OAuth token to be used for authorization.
         */
        @SerializedName("access_token")
        val accessToken: String,
        /**
         * The OAuth token type. Mastodon uses Bearer tokens.
         */
        @SerializedName("token_type")
        val tokenType: String,
        /**
         * The OAuth scopes granted by this token, space-separated.
         */
        @SerializedName("scope")
        val scope: String,
        /**
         * When the token was generated. (UNIX Timestamp)
         */
        @SerializedName("created_at")
        val createdAt: Long,
    )

    data class Emoji(
        // Required attributes

        /**
         * The name of the custom emoji.
         */
        @SerializedName("shortcode")
        val shortcode: String,
        /**
         * A link to the custom emoji. (URL)
         */
        @SerializedName("url")
        val url: String,
        /**
         * A link to a static copy of the custom emoji. (URL)
         */
        @SerializedName("static_url")
        val staticUrl: String,
        /**
         * Whether this Emoji should be visible in the picker or unlisted.
         */
        @SerializedName("visible_in_picker")
        val visibleInPicker: Boolean,

        // Optional attributes

        /**
         * Used for sorting custom emoji in the picker.
         */
        @SerializedName("category")
        val category: String,
    )

    data class Field(
        // Required attributes

        /**
         * The key of a given field's key-value pair.
         */
        @SerializedName("name")
        val name: String,
        /**
         * The value associated with the `name` key. (HTML)
         */
        @SerializedName("value")
        val value: String,

        // Optional attributes

        /**
         * Timestamp of when the server verified a URL value for a rel="me” link. (ISO 8601 Datetime) if `value` is a verified URL. Otherwise, null
         */
        @SerializedName("verified_at")
        val verifiedAt: String?,
    )

    data class Source(
        // Base attributes

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

        // Nullable attributes

        /**
         * The default post privacy to be used for new statuses. (Enumerable, oneOf)
         * `public` = Public post
         * `unlisted` = Unlisted post
         * `private` = Followers-only post
         * `direct` = Direct post
         */
        @SerializedName("privacy")
        val privacy: String?,
        /**
         * Whether new statuses should be marked sensitive by default.
         */
        @SerializedName("sensitive")
        val sensitive: Boolean?,
        /**
         * The default posting language for new statuses. (ISO 639-1 language two-letter code)
         */
        @SerializedName("language")
        val language: String?,
        /**
         * The number of pending follow requests.
         */
        @SerializedName("follow_requests_count")
        val followRequestsCount: Long?,
    )

    data class Account(
        // Base attributes

        /**
         * The account id `header`. (cast from an integer, but not guaranteed to be a number)
         */
        @SerializedName("id")
        val id: String,
        /**
         * The username of the account, not including domain.
         */
        @SerializedName("username")
        val username: String,
        /**
         * The Webfinger account URI. Equal to `username` for local users, or `username@domain` for remote users.
         */
        @SerializedName("acct")
        val acct: String,
        /**
         * The location of the user's profile page. (URL)
         */
        @SerializedName("url")
        val url: String,

        // Display attributes

        /**
         * The profile's display name.
         */
        @SerializedName("display_name")
        val displayName: String,
        /**
         * The profile's bio / description.
         */
        @SerializedName("note")
        val note: String,
        /**
         * An image icon that is shown next to statuses and in the profile. (URL)
         */
        @SerializedName("avatar")
        val avatar: String,
        /**
         * A static version of the avatar. Equal to `avatar` if its value is a static image; different if `avatar` is an animated GIF. (URL)
         */
        @SerializedName("avatar_static")
        val avatarStatic: String,
        /**
         * An image banner that is shown above the profile and in profile cards. (URL)
         */
        @SerializedName("header")
        val header: String,
        /**
         * A static version of the header. Equal to `header` if its value is a static image; different if `header` is an animated GIF. (URL)
         */
        @SerializedName("header_static")
        val headerStatic: String,
        /**
         * Whether the account manually approves follow requests.
         */
        @SerializedName("locked")
        val locked: Boolean,
        /**
         * Custom emoji entities to be used when rendering the profile. If none, an empty array will be returned.
         */
        @SerializedName("emojis")
        val emojis: List<Emoji>,
        /**
         * Whether the account has opted into discovery features such as the profile directory.
         */
        @SerializedName("discoverable")
        val discoverable: Boolean,

        // Statistical attributes

        /**
         * When the account was created. (ISO 8601 Datetime)
         */
        @SerializedName("created_at")
        val createdAt: String,
        /**
         * When the most recent status was posted. (ISO 8601 Datetime)
         */
        @SerializedName("last_status_at")
        val lastStatusAt: String,
        /**
         * How many statuses are attached to this account.
         */
        @SerializedName("statuses_count")
        val statusesCount: Long,
        /**
         * The reported follows of this profile.
         */
        @SerializedName("followers_count")
        val followersCount: Long,
        /**
         * The reported followers of this profile.
         */
        @SerializedName("following_count")
        val followingCount: Long,

        // Optional attributes

        /**
         * Indicates that the profile is currently inactive and that its user has moved to a new account.
         */
        @SerializedName("moved")
        val moved: Account?,
        /**
         * Additional metadata attached to a profile as name-value pairs.
         */
        @SerializedName("fields")
        val fields: List<Field>?,
        /**
         * A presentational flag. Indicates that the account may perform automated actions, may not be monitored, or identifies as a robot.
         */
        @SerializedName("bot")
        val bot: Boolean?,
        /**
         * An extra entity to be used with API methods to verify credentials and update credentials.
         */
        @SerializedName("source")
        val source: Source,
        /**
         * An extra entity returned when an account is suspended.
         */
        @SerializedName("suspended")
        val suspended: Boolean?,
        /**
         * When a timed mute will expire, if applicable. (ISO 8601 Datetime)
         */
        @SerializedName("mute_expires_at")
        val muteExpiresAt: String,
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
     * Returns an access token, to be used during API calls that are not public.
     * @param grantType Set equal to `authorization_code` if code is provided in order to gain user-level access.
     * Otherwise, set equal to `client_credentials` to obtain app-level access only.
     * @param clientId Client ID, obtained during app registration
     * @param clientSecret Client secret, obtained during app registration
     * @param redirectUri Set a URI to redirect the user to. If this parameter is set to `urn:ietf:wg:oauth:2.0:oob`
     * then the token will be shown instead. Must match one of the redirect URIs declared during app registration.
     * @param scope List of requested OAuth scopes, separated by spaces. Must be a subset of scopes declared during
     * app registration. If not provided, defaults to `read`.
     * @param code A user authorization code, obtained via `/oauth/authorize`
     * @return Returns an access token, to be used during API calls that are not public.
     *
     * See https://docs.joinmastodon.org/methods/apps/oauth/
     */
    @FormUrlEncoded
    @POST("oauth/token")
    suspend fun getToken(
        @Field("grant_type") grantType: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("redirect_uri") redirectUri: String,
        @Field("scope") scope: String = "read",
        @Field("code") code: String? = null
    ): Entity.Token

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

    /**
     * @return the user's own [Entity.Account] with Source
     */
    @GET("api/v1/accounts/verify_credentials")
    suspend fun getAccount(@Header("Authorization") bearerToken: String): Entity.Account

}
