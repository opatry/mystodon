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

import net.opatry.mystodon.api.entity.Marker
import net.opatry.mystodon.api.entity.MarkerData

val markersData = listOf(
    EntityTestParam.build(
        """{
          "home": {
            "last_read_id": "103194548672408537",
            "version": 462,
            "updated_at": "2019-11-24T19:39:39.337Z"
          },
          "notifications": {
            "last_read_id": "35050107",
            "version": 356,
            "updated_at": "2019-11-25T13:47:31.333Z"
          }
        }""".trimIndent(),
        Marker(
            home = MarkerData(
                lastReadId = "103194548672408537",
                version = 462,
                updatedAt = "2019-11-24T19:39:39.337Z",
            ),
            notifications = MarkerData(
                lastReadId = "35050107",
                version = 356,
                updatedAt = "2019-11-25T13:47:31.333Z",
            ),
        )
    ),
)
