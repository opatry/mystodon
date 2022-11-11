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

import net.opatry.mystodon.api.entity.Filter
import net.opatry.mystodon.api.entity.FilterContext

val filtersData = listOf(
    EntityTestParam.build(
        """{
          "id": "8449",
          "phrase": "test",
          "context": [
            "home",
            "notifications",
            "public",
            "thread"
          ],
          "whole_word": false,
          "expires_at": "2019-11-26T09:08:06.254Z",
          "irreversible": true
        }""".trimIndent(),
        Filter(
            id = "8449",
            phrase = "test",
            context = listOf(
                FilterContext.Home,
                FilterContext.Notifications,
                FilterContext.Public,
                FilterContext.Thread,
            ),
            isWholeWord = false,
            expiresAt = "2019-11-26T09:08:06.254Z",
            isIrreversible = true
        ),
    ),
)
