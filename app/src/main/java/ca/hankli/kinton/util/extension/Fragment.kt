package ca.hankli.kinton.util.extension

import android.content.Intent
import android.net.Uri
import android.os.VibrationEffect
import android.os.VibrationEffect.DEFAULT_AMPLITUDE
import android.os.Vibrator
import androidx.annotation.IntRange
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import ca.hankli.kinton.util.isPermissionNotGranted

fun Fragment.visit(uri: String) {
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
}

fun Fragment.vibrate(millis: Long = 100L, amplitude: Int = DEFAULT_AMPLITUDE) {
    getSystemService(requireContext(), Vibrator::class.java)?.run {
        if (hasVibrator()) vibrate(VibrationEffect.createOneShot(millis, amplitude))
    }
}

fun Fragment.askForPermissions(
    permissions: Array<out String>,
    @IntRange requestCode: Int,
    doOnAllGranted: () -> Unit
) {
    val deniedPermissions = mutableListOf<String>()

    for (permission in permissions) {
        if (isPermissionNotGranted(requireContext(), permission)) {
            deniedPermissions.add(permission)
        }
    }

    if (deniedPermissions.isEmpty()) {
        doOnAllGranted()
    } else {
        requestPermissions(deniedPermissions.toTypedArray(), requestCode)
    }
}