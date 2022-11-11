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

package net.opatry

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class PostsViewModelTest {

//    @get:Rule
//    var coroutinesRule = MainCoroutineRule()
//
//    @get:Rule
//    var instantTaskExecutorRule = InstantTaskExecutorRule()

//    private fun usingMastodonApi(test: (MockWebServer, MastodonApi) -> Unit) {
//        val mockServer = MockWebServer()
//        try {
//            mockServer.start()
//
//            val builder = Retrofit.Builder()
//                .baseUrl(mockServer.url("/"))
//                .addConverterFactory(GsonConverterFactory.create())
//            val service = builder.build().create(MastodonApi::class.java)
//            coroutinesRule.runBlocking {
//                test(mockServer, service)
//            }
//        } finally {
//            mockServer.shutdown()
//        }
//    }
}
