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

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.opatry.mystodon.data.AccountRepository
import net.opatry.mystodon.databinding.AuthCallbackActivityBinding
import javax.inject.Inject

class AuthCallbackActivity : AppCompatActivity() {
    @Inject
    lateinit var accountRepository: AccountRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = intent.data
        val error = data?.getQueryParameter("error")
        if (data == null || error != null) {
            val errorDescription = data?.getQueryParameter("error_description")
            val binding = AuthCallbackActivityBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.authCallbackErrorCause.text = error
            binding.authCallbackErrorDetail.text = errorDescription
        } else {
            val code = data.getQueryParameter("code")
            if (code != null) {
                accountRepository.code = code
                finish()
                val intent = Intent(this, MainActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                }
                startActivity(intent)
            }
        }

    }
}
