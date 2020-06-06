package ca.hankli.kinton.ui.util

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import ca.hankli.kinton.R
import ca.hankli.kinton.ui.main.MainViewModel
import ca.hankli.kinton.util.EMPTY
import ca.hankli.kinton.util.extension.vibrate
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.CaptureManager
import kotlinx.android.synthetic.main.fragment_scan.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ScanFragment : BaseFragment(R.layout.fragment_scan), BarcodeCallback {

    private lateinit var captureManager: CaptureManager

    private val sharedViewModel: MainViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        captureManager = CaptureManager(activity, view_barcode)
        captureManager.initializeFromIntent(activity?.intent, savedInstanceState)

        view_barcode.decodeSingle(this)
    }

    override fun barcodeResult(result: BarcodeResult?) {
        sharedViewModel.postBarcodeJson(result?.text ?: EMPTY)
        vibrate()
        findNavController().navigateUp()
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