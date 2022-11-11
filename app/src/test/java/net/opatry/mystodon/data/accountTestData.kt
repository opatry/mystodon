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

package net.opatry.mystodon.data

import net.opatry.mystodon.api.entity.Account
import net.opatry.mystodon.api.entity.Emoji
import net.opatry.mystodon.api.entity.Field

val accountsData = listOf(
    EntityTestParam.build(
        """{
          "id": "23634",
          "username": "noiob",
          "acct": "noiob@awoo.space",
          "display_name": "ikea shark fan account",
          "locked": false,
          "bot": false,
          "created_at": "2017-02-08T02:00:53.274Z",
          "note": "<p>:ms_rainbow_flag:​ :ms_bisexual_flagweb:​ :ms_nonbinary_flag:​ <a href=\"https://awoo.space/tags/awoo\" class=\"mention hashtag\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">#<span>awoo</span}.space <a href=\"https://awoo.space/tags/admin\" class=\"mention hashtag\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">#<span>admin</span} ~ <a href=\"https://awoo.space/tags/bi\" class=\"mention hashtag\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">#<span>bi</span} ~ <a href=\"https://awoo.space/tags/nonbinary\" class=\"mention hashtag\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">#<span>nonbinary</span} ~ compsci student ~ likes video <a href=\"https://awoo.space/tags/games\" class=\"mention hashtag\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">#<span>games</span} and weird/ old electronics and will post obsessively about both ~ avatar by <span class=\"h-card\"><a href=\"https://weirder.earth/@dzuk\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>dzuk</span}</span></p>",
          "url": "https://awoo.space/@noiob",
          "avatar": "https://files.mastodon.social/accounts/avatars/000/023/634/original/6ca8804dc46800ad.png",
          "avatar_static": "https://files.mastodon.social/accounts/avatars/000/023/634/original/6ca8804dc46800ad.png",
          "header": "https://files.mastodon.social/accounts/headers/000/023/634/original/256eb8d7ac40f49a.png",
          "header_static": "https://files.mastodon.social/accounts/headers/000/023/634/original/256eb8d7ac40f49a.png",
          "followers_count": 547,
          "following_count": 404,
          "statuses_count": 28468,
          "last_status_at": "2019-11-17T00:02:23.693Z",
          "emojis": [
            {
              "shortcode": "ms_rainbow_flag",
              "url": "https://files.mastodon.social/custom_emojis/images/000/028/691/original/6de008d6281f4f59.png",
              "static_url": "https://files.mastodon.social/custom_emojis/images/000/028/691/static/6de008d6281f4f59.png",
              "visible_in_picker": true
            },
            {
              "shortcode": "ms_bisexual_flag",
              "url": "https://files.mastodon.social/custom_emojis/images/000/050/744/original/02f94a5fca7eaf78.png",
              "static_url": "https://files.mastodon.social/custom_emojis/images/000/050/744/static/02f94a5fca7eaf78.png",
              "visible_in_picker": true
            },
            {
              "shortcode": "ms_nonbinary_flag",
              "url": "https://files.mastodon.social/custom_emojis/images/000/105/099/original/8106088bd4782072.png",
              "static_url": "https://files.mastodon.social/custom_emojis/images/000/105/099/static/8106088bd4782072.png",
              "visible_in_picker": true
            }
          ],
          "fields": [
            {
              "name": "Pronouns",
              "value": "they/them",
              "verified_at": null
            },
            {
              "name": "Alt",
              "value": "<span class=\"h-card\"><a href=\"https://cybre.space/@noiob\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>noiob</span}</span>",
              "verified_at": null
            },
            {
              "name": "Bots",
              "value": "<span class=\"h-card\"><a href=\"https://botsin.space/@darksouls\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>darksouls</span}</span>, <span class=\"h-card\"><a href=\"https://botsin.space/@nierautomata\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>nierautomata</span}</span>, <span class=\"h-card\"><a href=\"https://mastodon.social/@fedi\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>fedi</span}</span>, code for <span class=\"h-card\"><a href=\"https://botsin.space/@awoobot\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>awoobot</span}</span>",
              "verified_at": null
            },
            {
              "name": "Website",
              "value": "<a href=\"http://shork.xyz\" rel=\"nofollow noopener noreferrer\" target=\"_blank\"><span class=\"invisible\">http://</span><span class=\"\">shork.xyz</span><span class=\"invisible\"></span}",
              "verified_at": "2019-11-10T10:31:10.744+00:00"
            }
          ]
        }""".trimIndent(),
        Account(
            id = "23634",
            username = "noiob",
            acct = "noiob@awoo.space",
            displayName = "ikea shark fan account",
            isLocked = false,
            isBot = false,
            createdAt = "2017-02-08T02:00:53.274Z",
            note = "<p>:ms_rainbow_flag:​ :ms_bisexual_flagweb:​ :ms_nonbinary_flag:​ <a href=\"https://awoo.space/tags/awoo\" class=\"mention hashtag\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">#<span>awoo</span}.space <a href=\"https://awoo.space/tags/admin\" class=\"mention hashtag\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">#<span>admin</span} ~ <a href=\"https://awoo.space/tags/bi\" class=\"mention hashtag\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">#<span>bi</span} ~ <a href=\"https://awoo.space/tags/nonbinary\" class=\"mention hashtag\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">#<span>nonbinary</span} ~ compsci student ~ likes video <a href=\"https://awoo.space/tags/games\" class=\"mention hashtag\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">#<span>games</span} and weird/ old electronics and will post obsessively about both ~ avatar by <span class=\"h-card\"><a href=\"https://weirder.earth/@dzuk\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>dzuk</span}</span></p>",
            url = "https://awoo.space/@noiob",
            avatarUrl = "https://files.mastodon.social/accounts/avatars/000/023/634/original/6ca8804dc46800ad.png",
            avatarStaticUrl = "https://files.mastodon.social/accounts/avatars/000/023/634/original/6ca8804dc46800ad.png",
            headerUrl = "https://files.mastodon.social/accounts/headers/000/023/634/original/256eb8d7ac40f49a.png",
            headerStaticUrl = "https://files.mastodon.social/accounts/headers/000/023/634/original/256eb8d7ac40f49a.png",
            followersCount = 547,
            followingCount = 404,
            statusesCount = 28468,
            lastStatusAt = "2019-11-17T00:02:23.693Z",
            emojis = listOf(
                Emoji(
                    shortCode = "ms_rainbow_flag",
                    url = "https://files.mastodon.social/custom_emojis/images/000/028/691/original/6de008d6281f4f59.png",
                    staticUrl = "https://files.mastodon.social/custom_emojis/images/000/028/691/static/6de008d6281f4f59.png",
                    isVisibleInPicker = true,
                ),
                Emoji(
                    shortCode = "ms_bisexual_flag",
                    url = "https://files.mastodon.social/custom_emojis/images/000/050/744/original/02f94a5fca7eaf78.png",
                    staticUrl = "https://files.mastodon.social/custom_emojis/images/000/050/744/static/02f94a5fca7eaf78.png",
                    isVisibleInPicker = true,
                ),
                Emoji(
                    shortCode = "ms_nonbinary_flag",
                    url = "https://files.mastodon.social/custom_emojis/images/000/105/099/original/8106088bd4782072.png",
                    staticUrl = "https://files.mastodon.social/custom_emojis/images/000/105/099/static/8106088bd4782072.png",
                    isVisibleInPicker = true,
                ),
            ),
            fields = listOf(
                Field(
                    name = "Pronouns",
                    value = "they/them",
                    verifiedAt = null,
                ),
                Field(
                    name = "Alt",
                    value = "<span class=\"h-card\"><a href=\"https://cybre.space/@noiob\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>noiob</span}</span>",
                    verifiedAt = null
                ),
                Field(
                    name = "Bots",
                    value = "<span class=\"h-card\"><a href=\"https://botsin.space/@darksouls\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>darksouls</span}</span>, <span class=\"h-card\"><a href=\"https://botsin.space/@nierautomata\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>nierautomata</span}</span>, <span class=\"h-card\"><a href=\"https://mastodon.social/@fedi\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>fedi</span}</span>, code for <span class=\"h-card\"><a href=\"https://botsin.space/@awoobot\" class=\"u-url mention\" rel=\"nofollow noopener noreferrer\" target=\"_blank\">@<span>awoobot</span}</span>",
                    verifiedAt = null
                ),
                Field(
                    name = "Website",
                    value = "<a href=\"http://shork.xyz\" rel=\"nofollow noopener noreferrer\" target=\"_blank\"><span class=\"invisible\">http://</span><span class=\"\">shork.xyz</span><span class=\"invisible\"></span}",
                    verifiedAt = "2019-11-10T10:31:10.744+00:00"
                ),
            ),
        ),
    ),
)
