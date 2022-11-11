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

import net.opatry.mystodon.api.entity.MediaVisibility
import net.opatry.mystodon.api.entity.Preferences
import net.opatry.mystodon.api.entity.Visibility

val preferencesData = listOf(
    EntityTestParam.build(
        """{
          "posting:default:visibility": "public",
          "posting:default:sensitive": false,
          "posting:default:language": null,
          "reading:expand:media": "default",
          "reading:expand:spoilers": false
        }""".trimIndent(),
        Preferences(
            defaultVisibility = Visibility.Public,
            isSensitiveByDefault = false,
            defaultLanguage = null,
            defaultMediaVisibility = MediaVisibility.Default,
            areSpoilersExpandedByDefault = false,
        )
    ),
)