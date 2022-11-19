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

import com.google.gson.reflect.TypeToken
import net.opatry.join.mastodon.JoinInstanceTestParam
import net.opatry.mystodon.api.JoinMastodonCategory
import net.opatry.mystodon.api.JoinMastodonInstance

val joinMastodonInstancesTestData = listOf(
    // region https://api.joinmastodon.org/servers
    JoinInstanceTestParam(
        """[
          {
            "domain": "mstdn.jp",
            "version": "3.5.1",
            "description": "Mastodon日本鯖です． よろしくお願いいたします。 (Maintained by Sujitech, LLC)",
            "languages": [
              "ja"
            ],
            "region": "asia",
            "categories": [
              "general"
            ],
            "proxied_thumbnail": "https://proxy.joinmastodon.org/1f1fef40f1ccbaeef83b7eed4aab0f3f39049abe/68747470733a2f2f6d7374646e2e6a702f7061636b732f6d656469612f696d616765732f707265766965772d35646639383239303337316561643961373062633363643437333362626661372e6a7067",
            "total_users": 283901,
            "last_week_users": 67701,
            "approval_required": false,
            "language": "ja",
            "category": "general"
          },
          {
            "domain": "mastodonapp.uk",
            "version": "3.5.5",
            "description": "This is a Mastodon server for those in the UK or who want to talk to folks over here in the UK.",
            "languages": [
              "en"
            ],
            "region": "europe",
            "categories": [
              "regional"
            ],
            "proxied_thumbnail": "https://proxy.joinmastodon.org/64493c31ce97ba9d7b1ff19be3425ce8afee5f3b/68747470733a2f2f66696c65732e6d6173746f646f6e6170702e756b2f736974655f75706c6f6164732f66696c65732f3030302f3030302f3030312f6f726967696e616c2f706578656c732d766563746f72732d69636f6e2d3936383239392e6a7067",
            "total_users": 49612,
            "last_week_users": 29882,
            "approval_required": true,
            "language": "en",
            "category": "regional"
          }
        ]""".trimIndent(),
        object : TypeToken<ArrayList<JoinMastodonInstance>>() {}.type,
        listOf(
            JoinMastodonInstance(
                domain = "mstdn.jp",
                version = "3.5.1",
                description = "Mastodon日本鯖です． よろしくお願いいたします。 (Maintained by Sujitech, LLC)",
                languages = listOf(
                    "ja"
                ),
                region = "asia",
                categories = listOf(
                    "general"
                ),
                proxiedThumbnailUrl = "https://proxy.joinmastodon.org/1f1fef40f1ccbaeef83b7eed4aab0f3f39049abe/68747470733a2f2f6d7374646e2e6a702f7061636b732f6d656469612f696d616765732f707265766965772d35646639383239303337316561643961373062633363643437333362626661372e6a7067",
                totalUsersCount = 283901,
                lastWeekUsersCount = 67701,
                approvalRequired = false,
                language = "ja",
                category = "general",
            ),
            JoinMastodonInstance(
                domain = "mastodonapp.uk",
                version = "3.5.5",
                description = "This is a Mastodon server for those in the UK or who want to talk to folks over here in the UK.",
                languages = listOf(
                    "en"
                ),
                region = "europe",
                categories = listOf(
                    "regional"
                ),
                proxiedThumbnailUrl = "https://proxy.joinmastodon.org/64493c31ce97ba9d7b1ff19be3425ce8afee5f3b/68747470733a2f2f66696c65732e6d6173746f646f6e6170702e756b2f736974655f75706c6f6164732f66696c65732f3030302f3030302f3030312f6f726967696e616c2f706578656c732d766563746f72732d69636f6e2d3936383239392e6a7067",
                totalUsersCount = 49612,
                lastWeekUsersCount = 29882,
                approvalRequired = true,
                language = "en",
                category = "regional",
            ),
        )
    )
    // endregion
)

val joinMastodonCategoriesTestData = listOf(
    // region https://api.joinmastodon.org/categories
    JoinInstanceTestParam(
        """[
          {
            "category": "games",
            "servers_count": 1
          },
          {
            "category": "activism",
            "servers_count": 1
          },
          {
            "category": "regional",
            "servers_count": 1
          },
          {
            "category": "general",
            "servers_count": 9
          }
        ]""".trimIndent(),
        object : TypeToken<ArrayList<JoinMastodonCategory>>() {}.type,
        listOf(
            JoinMastodonCategory(
                category = "games",
                serversCount = 1,
            ),
            JoinMastodonCategory(
                category = "activism",
                serversCount = 1,
            ),
            JoinMastodonCategory(
                category = "regional",
                serversCount = 1,
            ),
            JoinMastodonCategory(
                category = "general",
                serversCount = 9,
            ),
        )
    )
    // endregion
)
