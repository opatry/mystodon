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
import net.opatry.mystodon.api.entity.Context
import net.opatry.mystodon.api.entity.Status
import net.opatry.mystodon.api.entity.Visibility

private fun buildStatusStub(
    id: String,
    createdAt: String,
    inReplyToId: String? = null,
): Status {
    return Status(
        id = id,
        uri = "",
        createdAt = createdAt,
        inReplyToId = inReplyToId,
        account = accountsData.first().expectedEntity as Account,
        content = "",
        visibility = Visibility.Public,
        isSensitive = false,
        spoilerText = "",
        mediaAttachments = emptyList(),
        application = Application("test app"),
        mentions = emptyList(),
        tags = emptyList(),
        emojis = emptyList(),
        reblogsCount = 0,
        favouritesCount = 0,
        repliesCount = 0,
    )
}

val contextsData = listOf(
    EntityTestParam.build(
        """{
          "ancestors": [
            {
              "id": "103188938570975982",
              "created_at": "2019-11-23T19:44:00.124Z",
              "in_reply_to_id": null,
            },
            {
              "id": "103188971072973252",
              "created_at": "2019-11-23T19:52:23.398Z",
              "in_reply_to_id": "103188938570975982",
            },
            {
              "id": "103188982235527758",
              "created_at": "2019-11-23T19:55:08.208Z",
              "in_reply_to_id": "103188971072973252",
          ],
          "descendants": [
            {
              "id": "103189026958574542",
              "created_at": "2019-11-23T20:06:36.011Z",
              "in_reply_to_id": "103189005915505698",
            }
          ]
        }
""".trimIndent(),
        Context(
            ancestors = listOf(
                buildStatusStub(
                    id = "103188938570975982",
                    createdAt = "2019-11-23T19:44:00.124Z",
                    inReplyToId = null,
                ),
                buildStatusStub(
                    id = "103188971072973252",
                    createdAt = "2019-11-23T19:52:23.398Z",
                    inReplyToId = "103188938570975982",
                ),
                buildStatusStub(
                    id = "103188982235527758",
                    createdAt = "2019-11-23T19:55:08.208Z",
                    inReplyToId = "103188971072973252",
                ),
            ),
            descendants = listOf(
                buildStatusStub(
                    id = "103189026958574542",
                    createdAt = "2019-11-23T20:06:36.011Z",
                    inReplyToId = "103189005915505698",
                ),
            ),
        ),
    ),
)
