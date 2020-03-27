package ca.hankli.kinton.ui.main.menu

import android.content.Context
import androidx.lifecycle.ViewModel
import ca.hankli.kinton.data.source.KINTON_MENU_CATEGORIES
import ca.hankli.kinton.data.source.KINTON_MENU_ITEMS
import ca.hankli.kinton.model.MenuCategory
import ca.hankli.kinton.model.MenuItem
import ca.hankli.kinton.util.json.adapter.IconResourceAdapter
import ca.hankli.kinton.util.json.adapter.PriceAdapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MenuViewModel : ViewModel() {

    fun getMenuCategories(context: Context): List<MenuCategory> {
        val moshi: Moshi = Moshi.Builder()
            .add(IconResourceAdapter(context))
            .build()

        val type = Types.newParameterizedType(List::class.java, MenuCategory::class.java)
        val adapter: JsonAdapter<List<MenuCategory>> = moshi.adapter(type)
        return adapter.fromJson(KINTON_MENU_CATEGORIES) ?: emptyList()
    }

    fun getMenuItemGroups(context: Context): Map<Int, List<MenuItem>> {
        val moshi: Moshi = Moshi.Builder()
            .add(IconResourceAdapter(context))
            .add(PriceAdapter())
            .build()

        val type = Types.newParameterizedType(List::class.java, MenuItem::class.java)
        val adapter: JsonAdapter<List<MenuItem>> = moshi.adapter(type)
        val list = adapter.fromJson(KINTON_MENU_ITEMS) ?: emptyList()

        return if (list.isEmpty()) emptyMap() else list.groupBy { it.type }
    }
}