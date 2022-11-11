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

import net.opatry.mystodon.api.entity.Attachment
import net.opatry.mystodon.api.entity.AttachmentType

val attachmentsData = listOf(
    // Image
    EntityTestParam.build(
        """{
          "id": "22345792",
          "type": "image",
          "url": "https://files.mastodon.social/media_attachments/files/022/345/792/original/57859aede991da25.jpeg",
          "preview_url": "https://files.mastodon.social/media_attachments/files/022/345/792/small/57859aede991da25.jpeg",
          "remote_url": null,
          "text_url": "https://mastodon.social/media/2N4uvkuUtPVrkZGysms",
          "meta": {
            "original": {
              "width": 640,
              "height": 480,
              "size": "640x480",
              "aspect": 1.3333333333333333
            },
            "small": {
              "width": 461,
              "height": 346,
              "size": "461x346",
              "aspect": 1.3323699421965318
            },
            "focus": {
              "x": -0.27,
              "y": 0.51
            }
          },
          "description": "test media description",
          "blurhash": "UFBWY:8_0Jxv4mx]t8t64.%M-:IUWGWAt6M}"
        }""".trimIndent(),
        Attachment(
            id = "22345792",
            type = AttachmentType.Image,
            url = "https://files.mastodon.social/media_attachments/files/022/345/792/original/57859aede991da25.jpeg",
            previewUrl = "https://files.mastodon.social/media_attachments/files/022/345/792/small/57859aede991da25.jpeg",
            remoteUrl = null,
            textUrl = "https://mastodon.social/media/2N4uvkuUtPVrkZGysms",
            /*
meta = {
    original = {
        width = 640,
        height = 480,
        size = "640x480",
        aspect = 1.3333333333333333
    },
    small = {
        width = 461,
        height = 346,
        size = "461x346",
        aspect = 1.3323699421965318
    },
    focus = {
        x = -0.27,
        y = 0.51
    }
},
            */
            description = "test media description",
            blurHash = "UFBWY:8_0Jxv4mx]t8t64.%M-:IUWGWAt6M}",
        )
    ),

    // Video
    EntityTestParam.build(
        """{
          "id": "22546306",
          "type": "video",
          "url": "https://files.mastodon.social/media_attachments/files/022/546/306/original/dab9a597f68b9745.mp4",
          "preview_url": "https://files.mastodon.social/media_attachments/files/022/546/306/small/dab9a597f68b9745.png",
          "remote_url": null,
          "text_url": "https://mastodon.social/media/wWd1HJIBmH1MZGDfg50",
          "meta": {
            "length": "0:01:28.65",
            "duration": 88.65,
            "fps": 24,
            "size": "1280x720",
            "width": 1280,
            "height": 720,
            "aspect": 1.7777777777777777,
            "audio_encode": "aac (LC) (mp4a / 0x6134706D)",
            "audio_bitrate": "44100 Hz",
            "audio_channels": "stereo",
            "original": {
              "width": 1280,
              "height": 720,
              "frame_rate": "6159375/249269",
              "duration": 88.654,
              "bitrate": 862056
            },
            "small": {
              "width": 400,
              "height": 225,
              "size": "400x225",
              "aspect": 1.7777777777777777
            }
          },
          "description": null,
          "blurhash": "U58E0g8_0M.94T?bIr00?bD%NGoM?bD%oLt7"
        }""".trimIndent(),
        Attachment(
            id = "22546306",
            type = AttachmentType.Video,
            url = "https://files.mastodon.social/media_attachments/files/022/546/306/original/dab9a597f68b9745.mp4",
            previewUrl = "https://files.mastodon.social/media_attachments/files/022/546/306/small/dab9a597f68b9745.png",
            remoteUrl = null,
            textUrl = "https://mastodon.social/media/wWd1HJIBmH1MZGDfg50",
            /*
  "meta": {
    "length": "0:01:28.65",
    "duration": 88.65,
    "fps": 24,
    "size": "1280x720",
    "width": 1280,
    "height": 720,
    "aspect": 1.7777777777777777,
    "audio_encode": "aac (LC) (mp4a / 0x6134706D)",
    "audio_bitrate": "44100 Hz",
    "audio_channels": "stereo",
    "original": {
      "width": 1280,
      "height": 720,
      "frame_rate": "6159375/249269",
      "duration": 88.654,
      "bitrate": 862056
    },
    "small": {
      "width": 400,
      "height": 225,
      "size": "400x225",
      "aspect": 1.7777777777777777
    }
  },
            */
            description = null,
            blurHash = "U58E0g8_0M.94T?bIr00?bD%NGoM?bD%oLt7",
        )
    ),

    // GIFV
    EntityTestParam.build(
        """{
          "id": "21130559",
          "type": "gifv",
          "url": "https://files.mastodon.social/media_attachments/files/021/130/559/original/bc84838f77991326.mp4",
          "preview_url": "https://files.mastodon.social/media_attachments/files/021/130/559/small/bc84838f77991326.png",
          "remote_url": null,
          "text_url": "https://mastodon.social/media/2ICiasGyjezmi7cQYM8",
          "meta": {
            "length": "0:00:01.11",
            "duration": 1.11,
            "fps": 33,
            "size": "600x332",
            "width": 600,
            "height": 332,
            "aspect": 1.8072289156626506,
            "original": {
              "width": 600,
              "height": 332,
              "frame_rate": "100/3",
              "duration": 1.11,
              "bitrate": 1627639
            },
            "small": {
              "width": 400,
              "height": 221,
              "size": "400x221",
              "aspect": 1.8099547511312217
            }
          },
          "description": null,
          "blurhash": "U58E0g8_0M.94T?bIr00?bD%NGoM?bD%oLt7"
        }""".trimIndent(),
        Attachment(
            id = "22345792",
            type = AttachmentType.GIFV,
            url = "https://files.mastodon.social/media_attachments/files/021/130/559/original/bc84838f77991326.mp4",
            previewUrl = "https://files.mastodon.social/media_attachments/files/021/130/559/small/bc84838f77991326.png",
            remoteUrl = null,
            textUrl = "https://mastodon.social/media/2ICiasGyjezmi7cQYM8",
            /*
  "meta": {
    "length": "0:00:01.11",
    "duration": 1.11,
    "fps": 33,
    "size": "600x332",
    "width": 600,
    "height": 332,
    "aspect": 1.8072289156626506,
    "original": {
      "width": 600,
      "height": 332,
      "frame_rate": "100/3",
      "duration": 1.11,
      "bitrate": 1627639
    },
    "small": {
      "width": 400,
      "height": 221,
      "size": "400x221",
      "aspect": 1.8099547511312217
    }
  },
            */
            description = null,
            blurHash = "URHT%Jm,2a1d%MRO%LozkrNH$*n*oMn\$Rjt7",
        )
    ),
    // Audio
    EntityTestParam.build(
        """{
          "id": "21165404",
          "type": "audio",
          "url": "https://files.mastodon.social/media_attachments/files/021/165/404/original/a31a4a46cd713cd2.mp3",
          "preview_url": "https://files.mastodon.social/media_attachments/files/021/165/404/small/a31a4a46cd713cd2.mp3",
          "remote_url": null,
          "text_url": "https://mastodon.social/media/5O4uILClVqBWx0NNgvo",
          "meta": {
            "length": "0:06:42.86",
            "duration": 402.86,
            "audio_encode": "mp3",
            "audio_bitrate": "44100 Hz",
            "audio_channels": "stereo",
            "original": {
              "duration": 402.860408,
              "bitrate": 166290
            }
          },
          "description": null,
          "blurhash": null
        }""".trimIndent(),
        Attachment(
            id = "21165404",
            type = AttachmentType.Audio,
            url = "https://files.mastodon.social/media_attachments/files/021/165/404/original/a31a4a46cd713cd2.mp3",
            previewUrl = "https://files.mastodon.social/media_attachments/files/021/165/404/small/a31a4a46cd713cd2.mp3",
            remoteUrl = null,
            textUrl = "https://mastodon.social/media/5O4uILClVqBWx0NNgvo",
            /*
  "meta": {
    "length": "0:06:42.86",
    "duration": 402.86,
    "audio_encode": "mp3",
    "audio_bitrate": "44100 Hz",
    "audio_channels": "stereo",
    "original": {
      "duration": 402.860408,
      "bitrate": 166290
    }
  },
            */
            description = null,
            blurHash = null,
        ),
    ),
)
