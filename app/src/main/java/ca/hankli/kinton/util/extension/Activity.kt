package ca.hankli.kinton.util.extension

import android.app.Activity
import android.content.Intent
import android.net.Uri

fun Activity.visit(uri: String) {
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
}