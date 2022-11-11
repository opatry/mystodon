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

import net.opatry.mystodon.api.entity.Card

val cardsData = listOf(
    // video
    EntityTestParam.build(
        """{
          "url": "https://www.youtube.com/watch?v=OMv_EPMED8Y",
          "title": "♪ Brand New Friend (Christmas Song!)",
          "description": "",
          "type": "video",
          "author_name": "YOGSCAST Lewis & Simon",
          "author_url": "https://www.youtube.com/user/BlueXephos",
          "provider_name": "YouTube",
          "provider_url": "https://www.youtube.com/",
          "html": "<iframe width=\"480\" height=\"270\" src=\"https://www.youtube.com/embed/OMv_EPMED8Y?feature=oembed\" frameborder=\"0\" allowfullscreen=\"\"></iframe>",
          "width": 480,
          "height": 270,
          "image": "https://files.mastodon.social/preview_cards/images/014/179/145/original/9cf4b7cf5567b569.jpeg",
          "embed_url": "",
          "blurhash": "UvK0HNkV,:s9xBR%njog0fo2W=WBS5ozofV@"
        }""".trimIndent(),
        Card(
            url = "https://www.youtube.com/watch?v=OMv_EPMED8Y",
            title = "♪ Brand New Friend (Christmas Song!)",
            description = "",
            type = "video",
            authorName = "YOGSCAST Lewis & Simon",
            authorUrl = "https://www.youtube.com/user/BlueXephos",
            providerName = "YouTube",
            providerUrl = "https://www.youtube.com/",
            html = "<iframe width=\"480\" height=\"270\" src=\"https://www.youtube.com/embed/OMv_EPMED8Y?feature=oembed\" frameborder=\"0\" allowfullscreen=\"\"></iframe>",
            width = 480,
            height = 270,
            imageUrl = "https://files.mastodon.social/preview_cards/images/014/179/145/original/9cf4b7cf5567b569.jpeg",
            embedUrl = "",
            blurHash = "UvK0HNkV,:s9xBR%njog0fo2W=WBS5ozofV@"
        )
    ),
    // photo
    EntityTestParam.build(
        """{
          "url": "https://www.flickr.com/photos/tomfenskephotography/49088768431/",
          "title": "Oregon",
          "description": "",
          "type": "photo",
          "author_name": "Tom Fenske Photography",
          "author_url": "https://www.flickr.com/photos/tomfenskephotography/",
          "provider_name": "Flickr",
          "provider_url": "https://www.flickr.com/",
          "html": "",
          "width": 1024,
          "height": 427,
          "image": "https://files.mastodon.social/preview_cards/images/014/287/139/original/651b1c6976817824.jpeg",
          "embed_url": "https://live.staticflickr.com/65535/49088768431_6a4322b3bb_b.jpg",
          "blurhash": "UnE{@jt6M_oIAhjYs+ayT2WBf9ayRkkDXAj["
        }""".trimIndent(),
        Card(
            url = "https://www.flickr.com/photos/tomfenskephotography/49088768431/",
            title = "Oregon",
            description = "",
            type = "photo",
            authorName = "Tom Fenske Photography",
            authorUrl = "https://www.flickr.com/photos/tomfenskephotography/",
            providerName = "Flickr",
            providerUrl = "https://www.flickr.com/",
            html = "",
            width = 1024,
            height = 427,
            imageUrl = "https://files.mastodon.social/preview_cards/images/014/287/139/original/651b1c6976817824.jpeg",
            embedUrl = "https://live.staticflickr.com/65535/49088768431_6a4322b3bb_b.jpg",
            blurHash = "UnE{@jt6M_oIAhjYs+ayT2WBf9ayRkkDXAj["
        )
    ),
    // link
    EntityTestParam.build(
        """{
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
          "embed_url": "",
          "blurhash": null
        }""".trimIndent(),
        Card(
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
            blurHash = null
        ),
    ),
)
