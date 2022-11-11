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

import net.opatry.mystodon.api.entity.History
import net.opatry.mystodon.api.entity.Tag

val tagsData = listOf(
    EntityTestParam.build(
        """{
          "name": "nowplaying",
          "url": "https://mastodon.social/tags/nowplaying",
          "history": [
            {
              "day": "1574553600",
              "uses": "200",
              "accounts": "31"
            },
            {
              "day": "1574467200",
              "uses": "272",
              "accounts": "39"
            },
            {
              "day": "1574380800",
              "uses": "345",
              "accounts": "40"
            },
            {
              "day": "1574294400",
              "uses": "366",
              "accounts": "46"
            },
            {
              "day": "1574208000",
              "uses": "226",
              "accounts": "32"
            },
            {
              "day": "1574121600",
              "uses": "217",
              "accounts": "42"
            },
            {
              "day": "1574035200",
              "uses": "214",
              "accounts": "34"
            }
          ]
        }
        """.trimIndent(),
        Tag(
            name = "nowplaying",
            url = "https://mastodon.social/tags/nowplaying",
            history = listOf(
                History(
                    day = "1574553600",
                    usesCount = 200,
                    accountsCount = 31,
                ),
                History(
                    day = "1574467200",
                    usesCount = 272,
                    accountsCount = 39,
                ),
                History(
                    day = "1574380800",
                    usesCount = 345,
                    accountsCount = 40,
                ),
                History(
                    day = "1574294400",
                    usesCount = 366,
                    accountsCount = 46,
                ),
                History(
                    day = "1574208000",
                    usesCount = 226,
                    accountsCount = 32,
                ),
                History(
                    day = "1574121600",
                    usesCount = 217,
                    accountsCount = 42,
                ),
                History(
                    day = "1574035200",
                    usesCount = 214,
                    accountsCount = 34,
                ),
            ),
        )
    ),
)
