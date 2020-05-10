package ca.hankli.kinton.ui.util

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ca.hankli.kinton.R
import com.journeyapps.barcodescanner.CaptureManager
import kotlinx.android.synthetic.main.activity_scan.*

class ScanActivity : AppCompatActivity() {

    private lateinit var captureManager: CaptureManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        captureManager = CaptureManager(this, view_barcode)
        captureManager.initializeFromIntent(intent, savedInstanceState)

        view_barcode.decodeSingle { result ->
            Log.d("debug", result.text)
        }
    }

    override fun onResume() {
        super.onResume()
        captureManager.onResume()
    }

    override fun onPause() {
        super.onPause()
        captureManager.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        captureManager.onDestroy()
    }
}