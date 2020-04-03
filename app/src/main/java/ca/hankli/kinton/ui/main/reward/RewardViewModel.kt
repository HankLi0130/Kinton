package ca.hankli.kinton.ui.main.reward

import android.content.Context
import androidx.lifecycle.ViewModel
import ca.hankli.kinton.data.source.KINTON_REWARD_ITEMS
import ca.hankli.kinton.model.RewardItem
import ca.hankli.kinton.util.json.adapter.IconResourceAdapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class RewardViewModel : ViewModel() {

    fun getRewardItems(context: Context): List<RewardItem> {
        val moshi: Moshi = Moshi.Builder()
            .add(IconResourceAdapter(context))
            .build()

        val type = Types.newParameterizedType(List::class.java, RewardItem::class.java)
        val adapter: JsonAdapter<List<RewardItem>> = moshi.adapter(type)
        return adapter.fromJson(KINTON_REWARD_ITEMS) ?: emptyList()
    }
}