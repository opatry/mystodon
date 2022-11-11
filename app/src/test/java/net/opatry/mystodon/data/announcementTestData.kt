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

import net.opatry.mystodon.api.entity.Announcement
import net.opatry.mystodon.api.entity.AnnouncementReaction

val announcementsData = listOf(
    EntityTestParam.build(
        """{
          "id": "8",
          "text": "<p>Looks like there was an issue processing audio attachments without embedded art since yesterday due to an experimental new feature. That issue has now been fixed, so you may see older posts with audio from other servers pop up in your feeds now as they are being finally properly processed. Sorry!</p>",
          "is_published": false,
          "starts_at": null,
          "ends_at": null,
          "all_day": false,
          "created_at": "2020-07-03T01:27:38.726Z",
          "updated_at": "2020-07-03T01:27:38.752Z",
          "read": true,
          "mentions": [],
          "statuses": [],
          "tags": [],
          "emojis": [],
          "reactions": [
            {
              "name": "bongoCat",
              "count": 9,
              "me": false,
              "url": "https://files.mastodon.social/custom_emojis/images/000/067/715/original/fdba57dff7576d53.png",
              "static_url": "https://files.mastodon.social/custom_emojis/images/000/067/715/static/fdba57dff7576d53.png"
            },
            {
              "name": "thonking",
              "count": 1,
              "me": false,
              "url": "https://files.mastodon.social/custom_emojis/images/000/098/690/original/a8d36edc4a7032e8.png",
              "static_url": "https://files.mastodon.social/custom_emojis/images/000/098/690/static/a8d36edc4a7032e8.png"
            },
            {
              "name": "AAAAAA",
              "count": 1,
              "me": false,
              "url": "https://files.mastodon.social/custom_emojis/images/000/071/387/original/AAAAAA.png",
              "static_url": "https://files.mastodon.social/custom_emojis/images/000/071/387/static/AAAAAA.png"
            },
            {
              "name": "🤔",
              "count": 1,
              "me": true
            }
          ]
        }""".trimIndent(),
        Announcement(
            id = "8",
            text = "<p>Looks like there was an issue processing audio attachments without embedded art since yesterday due to an experimental new feature. That issue has now been fixed, so you may see older posts with audio from other servers pop up in your feeds now as they are being finally properly processed. Sorry!</p>",
            isPublished = false,
            startsAt = null,
            endsAt = null,
            isAllDay = false,
            createdAt = "2020-07-03T01:27:38.726Z",
            updatedAt = "2020-07-03T01:27:38.752Z",
            isRead = true,
            reactions = listOf(
                AnnouncementReaction(
                    name = "bongoCat",
                    count = 9,
                    isMe = false,
                    url = "https://files.mastodon.social/custom_emojis/images/000/067/715/original/fdba57dff7576d53.png",
                    staticUrl = "https://files.mastodon.social/custom_emojis/images/000/067/715/static/fdba57dff7576d53.png",
                ),
                AnnouncementReaction(
                    name = "thonking",
                    count = 1,
                    isMe = false,
                    url = "https://files.mastodon.social/custom_emojis/images/000/098/690/original/a8d36edc4a7032e8.png",
                    staticUrl = "https://files.mastodon.social/custom_emojis/images/000/098/690/static/a8d36edc4a7032e8.png",
                ),
                AnnouncementReaction(
                    name = "AAAAAA",
                    count = 1,
                    isMe = false,
                    url = "https://files.mastodon.social/custom_emojis/images/000/071/387/original/AAAAAA.png",
                    staticUrl = "https://files.mastodon.social/custom_emojis/images/000/071/387/static/AAAAAA.png",
                ),
                AnnouncementReaction(
                    name = "🤔",
                    count = 1,
                    isMe = true,
                ),
            ),
        )
    ),
)

val announcementReactionsData = listOf(
    EntityTestParam.build(
        """{
          "name": "bongoCat",
          "count": 9,
          "me": false,
          "url": "https://files.mastodon.social/custom_emojis/images/000/067/715/original/fdba57dff7576d53.png",
          "static_url": "https://files.mastodon.social/custom_emojis/images/000/067/715/static/fdba57dff7576d53.png"
        }""".trimIndent(),
        AnnouncementReaction(
            name = "bongoCat",
            count = 9,
            isMe = false,
            url = "https://files.mastodon.social/custom_emojis/images/000/067/715/original/fdba57dff7576d53.png",
            staticUrl = "https://files.mastodon.social/custom_emojis/images/000/067/715/static/fdba57dff7576d53.png"
        ),
    ),
    EntityTestParam.build(
        """{
          "name": "🤔",
          "count": 1,
          "me": true
        }""".trimIndent(),
        AnnouncementReaction(
            name = "🤔",
            count = 1,
            isMe = true,
        ),
    ),
)
