package ca.hankli.kinton.util.extension

import android.app.Activity
import android.content.Context.VIBRATOR_SERVICE
import android.content.Intent
import android.net.Uri
import android.os.VibrationEffect
import android.os.VibrationEffect.DEFAULT_AMPLITUDE
import android.os.Vibrator

fun Activity.visit(uri: String) = startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))

fun Activity.vibrate(milliseconds: Long = 100L, amplitude: Int = DEFAULT_AMPLITUDE) {
    val vib: Vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

    if (vib.hasVibrator()) {
        vib.vibrate(
            VibrationEffect.createOneShot(milliseconds, amplitude)
        )
    }
}