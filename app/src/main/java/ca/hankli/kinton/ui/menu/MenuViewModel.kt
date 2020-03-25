package ca.hankli.kinton.ui.menu

import android.content.Context
import androidx.lifecycle.ViewModel
import ca.hankli.kinton.data.source.KINTON_MENU_ITEMS
import ca.hankli.kinton.model.MenuItem
import ca.hankli.kinton.util.json.adapter.IconResourceAdapter
import ca.hankli.kinton.util.json.adapter.PriceAdapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MenuViewModel : ViewModel() {

    fun getMenuItems(context: Context): List<MenuItem> {
        val moshi: Moshi = Moshi.Builder()
            .add(IconResourceAdapter(context))
            .add(PriceAdapter())
            .build()

        val type = Types.newParameterizedType(List::class.java, MenuItem::class.java)
        val adapter: JsonAdapter<List<MenuItem>> = moshi.adapter(type)
        return adapter.fromJson(KINTON_MENU_ITEMS) ?: emptyList()
    }
}