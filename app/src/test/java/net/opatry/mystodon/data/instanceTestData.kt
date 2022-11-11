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
import net.opatry.mystodon.api.entity.Field
import net.opatry.mystodon.api.entity.Instance
import net.opatry.mystodon.api.entity.InstanceStats
import net.opatry.mystodon.api.entity.InstanceUrl

val instancesData = listOf(
    EntityTestParam.build(
        """{
          "uri": "mastodon.social",
          "title": "Mastodon",
          "short_description": "Server run by the main developers of the project <img draggable=\"false\" alt=\"🐘\" class=\"emojione\" src=\"https://mastodon.social/emoji/1f418.svg\" /> It is not focused on any particular niche interest - everyone is welcome as long as you follow our code of conduct!",
          "description": "Server run by the main developers of the project <img draggable=\"false\" alt=\"🐘\" class=\"emojione\" src=\"https://mastodon.social/emoji/1f418.svg\" /> It is not focused on any particular niche interest - everyone is welcome as long as you follow our code of conduct!",
          "email": "staff@mastodon.social",
          "version": "3.0.1",
          "urls": {
            "streaming_api": "wss://mastodon.social"
          },
          "stats": {
            "user_count": 415526,
            "status_count": 17085754,
            "domain_count": 11834
          },
          "thumbnail": "https://files.mastodon.social/site_uploads/files/000/000/001/original/vlcsnap-2018-08-27-16h43m11s127.png",
          "languages": [
            "en"
          ],
          "registrations": true,
          "approval_required": false,
          "invites_enabled": false,
          "contact_account": {
            "id": "1",
            "username": "Gargron",
            "acct": "Gargron",
            "display_name": "Eugen",
            "locked": false,
            "bot": false,
            "created_at": "2016-03-16T14:34:26.392Z",
            "note": "<p>Developer of Mastodon and administrator of mastodon.social. I post service announcements, development updates, and personal stuff.</p>",
            "url": "https://mastodon.social/@Gargron",
            "avatar": "https://files.mastodon.social/accounts/avatars/000/000/001/original/d96d39a0abb45b92.jpg",
            "avatar_static": "https://files.mastodon.social/accounts/avatars/000/000/001/original/d96d39a0abb45b92.jpg",
            "header": "https://files.mastodon.social/accounts/headers/000/000/001/original/c91b871f294ea63e.png",
            "header_static": "https://files.mastodon.social/accounts/headers/000/000/001/original/c91b871f294ea63e.png",
            "followers_count": 317112,
            "following_count": 453,
            "statuses_count": 60903,
            "last_status_at": "2019-11-26T21:14:44.522Z",
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
          }
        }""".trimIndent(),
        Instance(
            uri = "mastodon.social",
            title = "Mastodon",
            shortDescription = "Server run by the main developers of the project <img draggable=\"false\" alt=\"🐘\" class=\"emojione\" src=\"https://mastodon.social/emoji/1f418.svg\" /> It is not focused on any particular niche interest - everyone is welcome as long as you follow our code of conduct!",
            description = "Server run by the main developers of the project <img draggable=\"false\" alt=\"🐘\" class=\"emojione\" src=\"https://mastodon.social/emoji/1f418.svg\" /> It is not focused on any particular niche interest - everyone is welcome as long as you follow our code of conduct!",
            email = "staff@mastodon.social",
            version = "3.0.1",
            urls = InstanceUrl(streamingApiUrl = "wss://mastodon.social"),
            stats = InstanceStats(
                userCount = 415526,
                statusCount = 17085754,
                domainCount = 11834,
            ),
            thumbnailUrl = "https://files.mastodon.social/site_uploads/files/000/000/001/original/vlcsnap-2018-08-27-16h43m11s127.png",
            languages = listOf("en"),
            areRegistrationsEnabled = true,
            isApprovalRequired = false,
            areInvitesEnabled = false,
            contactAccount = Account(
                id = "1",
                username = "Gargron",
                acct = "Gargron",
                displayName = "Eugen",
                isLocked = false,
                isBot = false,
                createdAt = "2016-03-16T14:34:26.392Z",
                note = "<p>Developer of Mastodon and administrator of mastodon.social. I post service announcements, development updates, and personal stuff.</p>",
                url = "https://mastodon.social/@Gargron",
                avatarUrl = "https://files.mastodon.social/accounts/avatars/000/000/001/original/d96d39a0abb45b92.jpg",
                avatarStaticUrl = "https://files.mastodon.social/accounts/avatars/000/000/001/original/d96d39a0abb45b92.jpg",
                headerUrl = "https://files.mastodon.social/accounts/headers/000/000/001/original/c91b871f294ea63e.png",
                headerStaticUrl = "https://files.mastodon.social/accounts/headers/000/000/001/original/c91b871f294ea63e.png",
                followersCount = 317112,
                followingCount = 453,
                statusesCount = 60903,
                lastStatusAt = "2019-11-26T21:14:44.522Z",
                emojis = emptyList(),
                fields = listOf(
                    Field(
                        name = "Patreon",
                        value = "<a href=\"https://www.patreon.com/mastodon\" rel=\"me nofollow noopener noreferrer\" target=\"_blank\"><span class=\"invisible\">https://www.</span><span class=\"\">patreon.com/mastodon</span><span class=\"invisible\"></span}",
                        verifiedAt = null,
                    ),
                    Field(
                        name = "Homepage",
                        value = "<a href=\"https://zeonfederated.com\" rel=\"me nofollow noopener noreferrer\" target=\"_blank\"><span class=\"invisible\">https://</span><span class=\"\">zeonfederated.com</span><span class=\"invisible\"></span}",
                        verifiedAt = "2019-07-15T18:29:57.191+00:00",
                    ),
                ),
            ),
        ),
    ),
)
