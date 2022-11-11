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
import net.opatry.mystodon.api.entity.Application
import net.opatry.mystodon.api.entity.Card
import net.opatry.mystodon.api.entity.Field
import net.opatry.mystodon.api.entity.Status
import net.opatry.mystodon.api.entity.Visibility

val statusData = listOf(
    EntityTestParam.build(
        """{
          "id": "103270115826048975",
          "created_at": "2019-12-08T03:48:33.901Z",
          "in_reply_to_id": null,
          "in_reply_to_account_id": null,
          "sensitive": false,
          "spoiler_text": "",
          "visibility": "public",
          "language": "en",
          "uri": "https://mastodon.social/users/Gargron/statuses/103270115826048975",
          "url": "https://mastodon.social/@Gargron/103270115826048975",
          "replies_count": 5,
          "reblogs_count": 6,
          "favourites_count": 11,
          "favourited": false,
          "reblogged": false,
          "muted": false,
          "bookmarked": false,
          "content": "<p>&quot;I lost my inheritance with one wrong digit on my sort code&quot;</p><p><a href=\"https://www.theguardian.com/money/2019/dec/07/i-lost-my-193000-inheritance-with-one-wrong-digit-on-my-sort-code\" rel=\"nofollow noopener noreferrer\" target=\"_blank\"><span class=\"invisible\">https://www.</span><span class=\"ellipsis\">theguardian.com/money/2019/dec</span><span class=\"invisible\">/07/i-lost-my-193000-inheritance-with-one-wrong-digit-on-my-sort-code</span}</p>",
          "reblog": null,
          "application": {
            "name": "Web",
            "website": null
          },
          "account": {
            "id": "1",
            "username": "Gargron",
            "acct": "Gargron",
            "display_name": "Eugen",
            "locked": false,
            "bot": false,
            "discoverable": true,
            "group": false,
            "created_at": "2016-03-16T14:34:26.392Z",
            "note": "<p>Developer of Mastodon and administrator of mastodon.social. I post service announcements, development updates, and personal stuff.</p>",
            "url": "https://mastodon.social/@Gargron",
            "avatar": "https://files.mastodon.social/accounts/avatars/000/000/001/original/d96d39a0abb45b92.jpg",
            "avatar_static": "https://files.mastodon.social/accounts/avatars/000/000/001/original/d96d39a0abb45b92.jpg",
            "header": "https://files.mastodon.social/accounts/headers/000/000/001/original/c91b871f294ea63e.png",
            "header_static": "https://files.mastodon.social/accounts/headers/000/000/001/original/c91b871f294ea63e.png",
            "followers_count": 322930,
            "following_count": 459,
            "statuses_count": 61323,
            "last_status_at": "2019-12-10T08:14:44.811Z",
            "emojis": [],
            "fields": [
              {
                "name": "Patreon",
                "value": "<a href=\"https://www.patreon.com/mastodon\" rel=\"me nofollow noopener noreferrer\" target=\"_blank\"><span class=\"invisible\">https://www.</span><span class=\"\">patreon.com/mastodon</span><span class=\"invisible\"></span}",
                "verified_at": null
              },
              {
                "name": "Homepage",
                "value": "<a href=\"https://zeonfederated.com\" rel=\"me nofollow noopener noreferrer\" target=\"_blank\"><span class=\"invisible\">https://</span><span class=\"\">zeonfederated.com</span><span class=\"invisible\"></span}",
                "verified_at": "2019-07-15T18:29:57.191+00:00"
              }
            ]
          },
          "media_attachments": [],
          "mentions": [],
          "tags": [],
          "emojis": [],
          "card": {
            "url": "https://www.theguardian.com/money/2019/dec/07/i-lost-my-193000-inheritance-with-one-wrong-digit-on-my-sort-code",
            "title": "‘I lost my £193,000 inheritance – with one wrong digit on my sort code’",
            "description": "When Peter Teich’s money went to another Barclays customer, the bank offered £25 as a token gesture",
            "type": "link",
            "author_name": "",
            "author_url": "",
            "provider_name": "",
            "provider_url": "",
            "html": "",
            "width": 0,
            "height": 0,
            "image": null,
            "embed_url": ""
          },
          "poll": null
        }""".trimIndent(),
        Status(
            id = "103270115826048975",
            createdAt = "2019-12-08T03:48:33.901Z",
            inReplyToId = null,
            inReplyToAccountId = null,
            isSensitive = false,
            spoilerText = "",
            visibility = Visibility.Public,
            language = "en",
            uri = "https://mastodon.social/users/Gargron/statuses/103270115826048975",
            url = "https://mastodon.social/@Gargron/103270115826048975",
            repliesCount = 5,
            reblogsCount = 6,
            favouritesCount = 11,
            isFavourited = false,
            isReblogged = false,
            isMuted = false,
            isBookmarked = false,
            content = "<p>&quot;I lost my inheritance with one wrong digit on my sort code&quot;</p><p><a href=\"https://www.theguardian.com/money/2019/dec/07/i-lost-my-193000-inheritance-with-one-wrong-digit-on-my-sort-code\" rel=\"nofollow noopener noreferrer\" target=\"_blank\"><span class=\"invisible\">https://www.</span><span class=\"ellipsis\">theguardian.com/money/2019/dec</span><span class=\"invisible\">/07/i-lost-my-193000-inheritance-with-one-wrong-digit-on-my-sort-code</span}</p>",
            reblog = null,
            application = Application(
                name = "Web",
                websiteUrl = null
            ),
            account = Account(
                id = "1",
                username = "Gargron",
                acct = "Gargron",
                displayName = "Eugen",
                isLocked = false,
                isBot = false,
                isDiscoverable = true,
                createdAt = "2016-03-16T14:34:26.392Z",
                note = "<p>Developer of Mastodon and administrator of mastodon.social. I post service announcements, development updates, and personal stuff.</p>",
                url = "https://mastodon.social/@Gargron",
                avatarUrl = "https://files.mastodon.social/accounts/avatars/000/000/001/original/d96d39a0abb45b92.jpg",
                avatarStaticUrl = "https://files.mastodon.social/accounts/avatars/000/000/001/original/d96d39a0abb45b92.jpg",
                headerUrl = "https://files.mastodon.social/accounts/headers/000/000/001/original/c91b871f294ea63e.png",
                headerStaticUrl = "https://files.mastodon.social/accounts/headers/000/000/001/original/c91b871f294ea63e.png",
                followersCount = 322930,
                followingCount = 459,
                statusesCount = 61323,
                lastStatusAt = "2019-12-10T08:14:44.811Z",
                emojis = emptyList(),
                fields = listOf(
                    Field(
                        name = "Patreon",
                        value = "<a href=\"https://www.patreon.com/mastodon\" rel=\"me nofollow noopener noreferrer\" target=\"_blank\"><span class=\"invisible\">https://www.</span><span class=\"\">patreon.com/mastodon</span><span class=\"invisible\"></span}",
                        verifiedAt = null
                    ),
                    Field(
                        name = "Homepage",
                        value = "<a href=\"https://zeonfederated.com\" rel=\"me nofollow noopener noreferrer\" target=\"_blank\"><span class=\"invisible\">https://</span><span class=\"\">zeonfederated.com</span><span class=\"invisible\"></span}",
                        verifiedAt = "2019-07-15T18:29:57.191+00:00"
                    ),
                ),
            ),
            mediaAttachments = emptyList(),
            mentions = emptyList(),
            tags = emptyList(),
            emojis = emptyList(),
            card = Card(
                url = "https://www.theguardian.com/money/2019/dec/07/i-lost-my-193000-inheritance-with-one-wrong-digit-on-my-sort-code",
                title = "‘I lost my £193,000 inheritance – with one wrong digit on my sort code’",
                description = "When Peter Teich’s money went to another Barclays customer, the bank offered £25 as a token gesture",
                type = "link",
                authorName = "",
                authorUrl = "",
                providerName = "",
                providerUrl = "",
                html = "",
                width = 0,
                height = 0,
                imageUrl = null,
                embedUrl = "",
            ),
            poll = null,
        )
    ),
)
