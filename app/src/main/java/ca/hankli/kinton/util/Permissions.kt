package ca.hankli.kinton.util

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED

/**
 * Check for permission
 */
fun isPermissionNotGranted(context: Context, permission: String): Boolean {
    return ContextCompat.checkSelfPermission(context, permission) != PERMISSION_GRANTED
}

fun arePermissionGranted(grantResults: IntArray): Boolean {
    return grantResults.isNotEmpty() && grantResults.all { it == PERMISSION_GRANTED }
}