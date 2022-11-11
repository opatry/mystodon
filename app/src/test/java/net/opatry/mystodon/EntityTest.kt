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

package net.opatry.mystodon

import com.google.gson.Gson
import net.opatry.mystodon.api.entity.Field
import net.opatry.mystodon.data.EntityTestParam
import net.opatry.mystodon.data.accountsData
import net.opatry.mystodon.data.activitiesData
import net.opatry.mystodon.data.announcementReactionsData
import net.opatry.mystodon.data.announcementsData
import net.opatry.mystodon.data.applicationsData
import net.opatry.mystodon.data.attachmentsData
import net.opatry.mystodon.data.cardsData
import net.opatry.mystodon.data.contextsData
import net.opatry.mystodon.data.emojisData
import net.opatry.mystodon.data.errorsData
import net.opatry.mystodon.data.featuredTagsData
import net.opatry.mystodon.data.fieldsData
import net.opatry.mystodon.data.filtersData
import net.opatry.mystodon.data.historiesData
import net.opatry.mystodon.data.identityProofsData
import net.opatry.mystodon.data.instancesData
import net.opatry.mystodon.data.listsData
import net.opatry.mystodon.data.markersData
import net.opatry.mystodon.data.mentionsData
import net.opatry.mystodon.data.pollsData
import net.opatry.mystodon.data.preferencesData
import net.opatry.mystodon.data.pushSubscriptionsData
import net.opatry.mystodon.data.relationshipsData
import net.opatry.mystodon.data.sourcesData
import net.opatry.mystodon.data.statusData
import net.opatry.mystodon.data.tagsData
import net.opatry.mystodon.data.tokensData
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class EntityTest(private val param: EntityTestParam) {

    private val gson: Gson = Gson()

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: {0}")
        fun data(): Iterable<EntityTestParam> {
            return buildList {
                addAll(accountsData)
                addAll(activitiesData)
                addAll(announcementsData)
                addAll(announcementReactionsData)
                addAll(applicationsData)
                // FIXME model needs improvements
                //addAll(attachmentsData)
                addAll(cardsData)
                // TODO test data is complex and cumbersome to write from example
                //addAll(contextsData)
                // TODO test data is complex and cumbersome to write from example
                //addAll(conversationsData)
                addAll(emojisData)
                addAll(errorsData)
                addAll(featuredTagsData)
                addAll(fieldsData)
                addAll(filtersData)
                addAll(historiesData)
                addAll(identityProofsData)
                addAll(instancesData)
                addAll(listsData)
                addAll(markersData)
                addAll(mentionsData)
                // TODO test data is complex and cumbersome to write from example
                //addAll(notificationsData)
                addAll(pollsData)
                addAll(preferencesData)
                addAll(pushSubscriptionsData)
                addAll(relationshipsData)
                // TODO test data is complex and cumbersome to write from example
                //addAll(resultsData)
                addAll(sourcesData)
                addAll(statusData)
                addAll(tagsData)
                addAll(tokensData)
            }
        }
    }

    @Test
    fun `JSON payload properly mapped to Entity`() {
        val entity = gson.fromJson(param.jsonPayload, param.entityClass)
        assertEquals(param.expectedEntity, entity)
    }
}
