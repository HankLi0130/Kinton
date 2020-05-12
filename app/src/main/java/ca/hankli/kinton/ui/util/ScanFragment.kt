package ca.hankli.kinton.ui.util

import android.os.Bundle
import android.util.Log
import android.view.View
import ca.hankli.kinton.R
import ca.hankli.kinton.util.extension.vibrate
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.CaptureManager
import kotlinx.android.synthetic.main.fragment_scan.*

class ScanFragment : BaseFragment(), BarcodeCallback {

    override val layoutRes: Int
        get() = R.layout.fragment_scan

    private lateinit var captureManager: CaptureManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        captureManager = CaptureManager(activity, view_barcode)
        captureManager.initializeFromIntent(activity?.intent, savedInstanceState)

        view_barcode.decodeSingle(this)
    }

    override fun barcodeResult(result: BarcodeResult?) {
        // TODO return result
        Log.d("debug", result.toString())
        vibrate()
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