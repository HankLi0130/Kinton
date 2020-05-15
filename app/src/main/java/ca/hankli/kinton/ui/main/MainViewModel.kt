package ca.hankli.kinton.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.hankli.kinton.util.Event

class MainViewModel : ViewModel() {

    // ScanEvent comes from ScanFragment, all ScanEvents (QR Code) are JSON format (String)
    private val _scanEvent = MutableLiveData<Event<String>>()
    val scanEvent: LiveData<Event<String>>
        get() = _scanEvent

    fun postBarcodeJson(json: String) {
        _scanEvent.value = Event(json)
    }
}