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

import net.opatry.mystodon.api.entity.Poll
import net.opatry.mystodon.api.entity.PollOptions

val pollsData = listOf(
    EntityTestParam.build(
        """{
          "id": "34830",
          "expires_at": "2019-12-05T04:05:08.302Z",
          "expired": true,
          "multiple": false,
          "votes_count": 10,
          "voters_count": null,
          "voted": true,
          "own_votes": [
            1
          ],
          "options": [
            {
              "title": "accept",
              "votes_count": 6
            },
            {
              "title": "deny",
              "votes_count": 4
            }
          ],
          "emojis": []
        }""".trimIndent(),
        Poll(
            id = "34830",
            expiresAt = "2019-12-05T04:05:08.302Z",
            isExpired = true,
            isMultiple = false,
            votesCount = 10,
            votersCount = null,
            hasVoted = true,
            ownVotes = listOf(1),
            options = listOf(
                PollOptions(
                    title = "accept",
                    votesCount = 6
                ),
                PollOptions(
                    title = "deny",
                    votesCount = 4
                ),
            ),
            emojis = emptyList(),
        )
    ),
)
