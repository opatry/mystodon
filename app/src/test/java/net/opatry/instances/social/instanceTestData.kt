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

package net.opatry.instances.social

import net.opatry.mystodon.api.Instance
import net.opatry.mystodon.api.InstanceInfo
import net.opatry.mystodon.api.InstancesList
import net.opatry.mystodon.api.InstancesPagination

val instancesSocialTestData = listOf(
    // region https://instances.social/api/1.0/instances/sample?count=1
    InstancesTestParam.build(
        """{
          "instances": [
            {
              "id": "5b45391dfa6236722f76287f",
              "name": "social.l4p1n.met-hardware.fr",
              "added_at": "2018-07-10T22:54:21.005Z",
              "updated_at": "2020-02-07T14:17:54.604Z",
              "checked_at": "2020-02-07T14:17:54.604Z",
              "uptime": 1,
              "up": false,
              "dead": false,
              "version": null,
              "ipv6": false,
              "https_score": null,
              "https_rank": null,
              "obs_score": null,
              "obs_rank": null,
              "users": "0",
              "statuses": "0",
              "connections": "0",
              "open_registrations": false,
              "info": null,
              "thumbnail": null,
              "thumbnail_proxy": null,
              "active_users": null,
              "email": null,
              "admin": null
            }
          ]
        }""".trimIndent(),
        InstancesList(
            instances = listOf(
                Instance(
                    id = "5b45391dfa6236722f76287f",
                    name = "social.l4p1n.met-hardware.fr",
                    addedAt = "2018-07-10T22:54:21.005Z",
                    updatedAt = "2020-02-07T14:17:54.604Z",
                    checkedAt = "2020-02-07T14:17:54.604Z",
                    uptime = 1,
                    isUp = false,
                    isDead = false,
                    version = null,
                    isIpv6 = false,
                    httpsScore = null,
                    httpsRank = null,
                    obsScore = null,
                    obsRank = null,
                    usersCount = 0,
                    statusesCount = 0,
                    connectionsCount = 0,
                    areRegistrationsOpen = false,
                    info = null,
                    thumbnailUrl = null,
                    thumbnailProxyUrl = null,
                    activeUsersCount = null,
                    email = null,
                    admin = null
                )
            ),
        )
    ),
    // endregion
    // region https://instances.social/api/1.0/instances/list?count=1
    InstancesTestParam.build(
        """{
          "instances": [
            {
              "id": "58e10e8d72782604c488bd35",
              "name": "mastodon.xyz",
              "added_at": null,
              "updated_at": "2022-11-15T20:52:09.087Z",
              "checked_at": "2022-11-15T20:52:09.087Z",
              "uptime": 1,
              "up": true,
              "dead": false,
              "version": "3.5.3",
              "ipv6": false,
              "https_score": 100,
              "https_rank": "A+",
              "obs_score": 125,
              "obs_rank": "A+",
              "users": "23863",
              "statuses": "1746998",
              "connections": "25974",
              "open_registrations": false,
              "info": {
                "short_description": "Generalistic and moderated instance. All opinions are welcome, but hate speeches are prohibited.",
                "full_description": "Generalistic and moderated instance. All opinions are welcome, but hate speeches are prohibited.\r\n\r\nUsers who don't respect rules will be silenced, or suspended if they harass other people or if the the violation is considered too large.",
                "topic": null,
                "languages": [
                  "en",
                  "fr"
                ],
                "other_languages_accepted": true,
                "federates_with": null,
                "prohibited_content": [
                  "nudity_nocw",
                  "pornography_nocw",
                  "illegalContentLinks",
                  "spam"
                ],
                "categories": []
              },
              "thumbnail": "https://6-28.mastodon.xyz/site_uploads/files/000/000/001/original/DN5wMUeVQAENPwp.jpg_large.jpeg",
              "thumbnail_proxy": "https://camo.instances.social/c2fd1641b7d329afc58f85ba3417fae0f4c82762/68747470733a2f2f362d32382e6d6173746f646f6e2e78797a2f736974655f75706c6f6164732f66696c65732f3030302f3030302f3030312f6f726967696e616c2f444e35774d5565565141454e5077702e6a70675f6c617267652e6a706567",
              "active_users": 1313,
              "email": "contact@thekinrar.fr",
              "admin": "TheKinrar"
            }
          ],
          "pagination": {
            "total": 4385,
            "next_id": "58e11571a0edbc7317b4f531"
          }
        }""".trimIndent(),
        InstancesList(
            instances = listOf(
                Instance(
                    id = "58e10e8d72782604c488bd35",
                    name = "mastodon.xyz",
                    addedAt = null,
                    updatedAt = "2022-11-15T20:52:09.087Z",
                    checkedAt = "2022-11-15T20:52:09.087Z",
                    uptime = 1,
                    isUp = true,
                    isDead = false,
                    version = "3.5.3",
                    isIpv6 = false,
                    httpsScore = 100,
                    httpsRank = "A+",
                    obsScore = 125,
                    obsRank = "A+",
                    usersCount = 23863,
                    statusesCount = 1746998,
                    connectionsCount = 25974,
                    areRegistrationsOpen = false,
                    info = InstanceInfo(
                        shortDescription = "Generalistic and moderated instance. All opinions are welcome, but hate speeches are prohibited.",
                        fullDescription = "Generalistic and moderated instance. All opinions are welcome, but hate speeches are prohibited.\r\n\r\nUsers who don't respect rules will be silenced, or suspended if they harass other people or if the the violation is considered too large.",
                        topic = null,
                        languages = listOf(
                            "en",
                            "fr"
                        ),
                        areOtherLanguagesAccepted = true,
                        federatesWith = null,
                        prohibitedContent = listOf(
                            "nudity_nocw",
                            "pornography_nocw",
                            "illegalContentLinks",
                            "spam"
                        ),
                        categories = emptyList()
                    ),
                    thumbnailUrl = "https://6-28.mastodon.xyz/site_uploads/files/000/000/001/original/DN5wMUeVQAENPwp.jpg_large.jpeg",
                    thumbnailProxyUrl = "https://camo.instances.social/c2fd1641b7d329afc58f85ba3417fae0f4c82762/68747470733a2f2f362d32382e6d6173746f646f6e2e78797a2f736974655f75706c6f6164732f66696c65732f3030302f3030302f3030312f6f726967696e616c2f444e35774d5565565141454e5077702e6a70675f6c617267652e6a706567",
                    activeUsersCount = 1313,
                    email = "contact@thekinrar.fr",
                    admin = "TheKinrar"
                )
            ),
            pagination = InstancesPagination(
                total = 4385,
                nextId = "58e11571a0edbc7317b4f531",
            )
        )
    ),
    // endregion
    // region https://instances.social/api/1.0/instances/search?q=mastodon.social&name=true
    InstancesTestParam.build(
        """{
          "instances": [
            {
              "id": "59067231bf4623585ed68d91",
              "name": "mastodon.social",
              "added_at": null,
              "updated_at": "2022-11-15T21:02:29.084Z",
              "checked_at": "2022-11-15T21:02:29.084Z",
              "uptime": 1,
              "up": true,
              "dead": false,
              "version": "4.0.2",
              "ipv6": false,
              "https_score": 5,
              "https_rank": "F ",
              "obs_score": 120,
              "obs_rank": "A+",
              "users": "835911",
              "statuses": "41689297",
              "connections": "31637",
              "open_registrations": false,
              "info": {
                "short_description": "General-purpose server run by the lead developer of Mastodon",
                "full_description": "This is just one part of the network, run by the main developers of the project 🐘 It is not focused on any particular niche interest - everyone is welcome as long as you follow our code of conduct!",
                "topic": null,
                "languages": [
                  "en"
                ],
                "other_languages_accepted": true,
                "federates_with": null,
                "prohibited_content": [
                  "nudity_nocw",
                  "pornography_nocw",
                  "illegalContentLinks",
                  "spam",
                  "advertising"
                ],
                "categories": []
              },
              "thumbnail": "https://files.mastodon.social/site_uploads/files/000/000/001/@1x/57c12f441d083cde.png",
              "thumbnail_proxy": "https://camo.instances.social/3eb87e258204c00f81a82a5b8fa573ab905df112/68747470733a2f2f66696c65732e6d6173746f646f6e2e736f6369616c2f736974655f75706c6f6164732f66696c65732f3030302f3030302f3030312f4031782f353763313266343431643038336364652e706e67",
              "active_users": 127276,
              "email": "staff@mastodon.social",
              "admin": "Gargron"
            }
          ],
          "pagination": {
            "total": 1
          }
        }""".trimIndent(),
        InstancesList(
            instances = listOf(
                Instance(
                    id = "59067231bf4623585ed68d91",
                    name = "mastodon.social",
                    addedAt = null,
                    updatedAt = "2022-11-15T21:02:29.084Z",
                    checkedAt = "2022-11-15T21:02:29.084Z",
                    uptime = 1,
                    isUp = true,
                    isDead = false,
                    version = "4.0.2",
                    isIpv6 = false,
                    httpsScore = 5,
                    httpsRank = "F ",
                    obsScore = 120,
                    obsRank = "A+",
                    usersCount = 835911,
                    statusesCount = 41689297,
                    connectionsCount = 31637,
                    areRegistrationsOpen = false,
                    info = InstanceInfo(
                        shortDescription = "General-purpose server run by the lead developer of Mastodon",
                        fullDescription = "This is just one part of the network, run by the main developers of the project 🐘 It is not focused on any particular niche interest - everyone is welcome as long as you follow our code of conduct!",
                        topic = null,
                        languages = listOf(
                            "en"
                        ),
                        areOtherLanguagesAccepted = true,
                        federatesWith = null,
                        prohibitedContent = listOf(
                            "nudity_nocw",
                            "pornography_nocw",
                            "illegalContentLinks",
                            "spam",
                            "advertising"
                        ),
                        categories = emptyList()
                    ),
                    thumbnailUrl = "https://files.mastodon.social/site_uploads/files/000/000/001/@1x/57c12f441d083cde.png",
                    thumbnailProxyUrl = "https://camo.instances.social/3eb87e258204c00f81a82a5b8fa573ab905df112/68747470733a2f2f66696c65732e6d6173746f646f6e2e736f6369616c2f736974655f75706c6f6164732f66696c65732f3030302f3030302f3030312f4031782f353763313266343431643038336364652e706e67",
                    activeUsersCount = 127276,
                    email = "staff@mastodon.social",
                    admin = "Gargron"
                )
            ),
            pagination = InstancesPagination(
                total = 1,
                nextId = null,
            )
        )
    ),
    // endregion
)
