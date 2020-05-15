package ca.hankli.kinton.ui.main.reward

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.hankli.kinton.repository.JsonParseRepo
import ca.hankli.kinton.util.Event

class RewardViewModel(val jsonParseRepo: JsonParseRepo) : ViewModel() {

    private val _snackbarEvent = MutableLiveData<Event<String>>()

    val snackbarEvent: LiveData<Event<String>>
        get() = _snackbarEvent

//    fun getRewardItems(): List<RewardItem> {
//        val type = Types.newParameterizedType(List::class.java, RewardItem::class.java)
//        val adapter: JsonAdapter<List<RewardItem>> = moshi.adapter(type)
//        return adapter.fromJson(KINTON_REWARD_ITEMS) ?: emptyList()
//    }

    fun handleJson(json: String) {
        val kintonCode = jsonParseRepo.parseKintonCodeJson(json)

        if (kintonCode != null) {
            // TODO save to database and show successful
            _snackbarEvent.value = Event("Parse successful!")
        } else {
            _snackbarEvent.value = Event("Parse Failed!")
        }
    }
}