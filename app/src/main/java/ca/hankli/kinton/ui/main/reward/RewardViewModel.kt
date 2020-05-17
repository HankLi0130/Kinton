package ca.hankli.kinton.ui.main.reward

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.hankli.kinton.data.source.KINTON_REWARD_ITEMS
import ca.hankli.kinton.model.KintonBowler
import ca.hankli.kinton.model.RewardItem
import ca.hankli.kinton.repository.JsonParseRepo
import ca.hankli.kinton.repository.PointTransactionRepo
import ca.hankli.kinton.util.Event
import com.squareup.moshi.JsonDataException

class RewardViewModel(
    private val jsonParseRepo: JsonParseRepo,
    private val pointTransactionRepo: PointTransactionRepo
) : ViewModel() {

    private val _snackbarEvent = MutableLiveData<Event<String>>()

    val snackbarEvent: LiveData<Event<String>>
        get() = _snackbarEvent

    private val _kintonBowlerInfo = MutableLiveData<KintonBowler>()

    val kintonBowlerInfo: LiveData<KintonBowler>
        get() = _kintonBowlerInfo

    fun getRewardItems(): List<RewardItem> {
        return jsonParseRepo.parseKintonRewardItems(KINTON_REWARD_ITEMS) ?: emptyList()
    }

    fun handleScanResult(json: String) {
        try {
            val kintonCode = jsonParseRepo.parseKintonCode(json)

            kintonCode?.let {
                when (kintonCode.action) {
                    1 -> withdraw(kintonCode.description, kintonCode.points)
                    2 -> deposit(kintonCode.description, kintonCode.points)
                }

            } ?: throw JsonDataException()

            notifyUIKintonBowlerInfo()

        } catch (e: JsonDataException) {
            _snackbarEvent.value = Event("Parse Failed!")
        }
    }

    private fun withdraw(description: String, points: Int) {
        with(pointTransactionRepo) {
            if (getCurrentBalance() > 0 && points <= getCurrentBalance()) {
                withdraw(description, points)
                _snackbarEvent.value = Event("Withdraw successful!")
            } else {
                _snackbarEvent.value = Event("Insufficient Balance!")
                return
            }
        }
    }

    private fun deposit(description: String, points: Int) {
        pointTransactionRepo.deposit(description, points)
        _snackbarEvent.value = Event("Deposit successful!")
    }

    fun notifyUIKintonBowlerInfo() {
        pointTransactionRepo.run {
            _kintonBowlerInfo.value = KintonBowler(
                getTotalPointsOfDeposits(),
                getTotalPointsOfWithdrawals(),
                getCurrentBalance()
            )
        }
    }
}