package net.opatry.mystodon.ui

import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.annotation.StringRes

fun TextView.setHtml(@StringRes stringRes: Int) {
    html = context.getString(stringRes)
}

var TextView.html: CharSequence
    get() = this.text
    set(value) {
        movementMethod = LinkMovementMethod.getInstance()
        linksClickable = true
        text = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            Html.fromHtml(value.toString(), Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(value.toString())
        }
    }
