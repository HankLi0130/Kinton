package ca.hankli.kinton.ui.main.reward

import androidx.lifecycle.ViewModel
import ca.hankli.kinton.data.source.KINTON_REWARD_ITEMS
import ca.hankli.kinton.model.RewardItem
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class RewardViewModel(val moshi: Moshi) : ViewModel() {

    fun getRewardItems(): List<RewardItem> {
        val type = Types.newParameterizedType(List::class.java, RewardItem::class.java)
        val adapter: JsonAdapter<List<RewardItem>> = moshi.adapter(type)
        return adapter.fromJson(KINTON_REWARD_ITEMS) ?: emptyList()
    }
}