package ca.hankli.kinton.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _barcodeJson = MutableLiveData<String>()
    val barcodeJson: LiveData<String>
        get() = _barcodeJson

    fun postBarcodeJson(json: String) {
        _barcodeJson.postValue(json)
    }
}