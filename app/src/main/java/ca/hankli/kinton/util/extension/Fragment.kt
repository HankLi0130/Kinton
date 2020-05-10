package ca.hankli.kinton.util.extension

import android.os.VibrationEffect
import androidx.annotation.IntRange
import androidx.fragment.app.Fragment
import ca.hankli.kinton.util.isPermissionNotGranted

fun Fragment.visit(uri: String) = activity?.visit(uri)

fun Fragment.vibrate(
    milliseconds: Long = 100L,
    amplitude: Int = VibrationEffect.DEFAULT_AMPLITUDE
) = activity?.vibrate(milliseconds, amplitude)


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