package ca.hankli.kinton.ui.main.menu

import androidx.lifecycle.ViewModel
import ca.hankli.kinton.data.source.KINTON_MENU_CATEGORIES
import ca.hankli.kinton.data.source.KINTON_MENU_ITEMS
import ca.hankli.kinton.model.MenuCategory
import ca.hankli.kinton.model.MenuItem
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MenuViewModel(val moshi: Moshi) : ViewModel() {

    fun getMenuCategories(): List<MenuCategory> {
        val type = Types.newParameterizedType(List::class.java, MenuCategory::class.java)
        val adapter: JsonAdapter<List<MenuCategory>> = moshi.adapter(type)
        return adapter.fromJson(KINTON_MENU_CATEGORIES) ?: emptyList()
    }

    fun getMenuItemGroups(): Map<Int, List<MenuItem>> {
        val type = Types.newParameterizedType(List::class.java, MenuItem::class.java)
        val adapter: JsonAdapter<List<MenuItem>> = moshi.adapter(type)
        val list = adapter.fromJson(KINTON_MENU_ITEMS) ?: emptyList()

        return if (list.isEmpty()) emptyMap() else list.groupBy { it.type }
    }
}