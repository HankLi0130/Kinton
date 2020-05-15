package ca.hankli.kinton.ui.main.menu

import androidx.lifecycle.ViewModel
import ca.hankli.kinton.data.source.KINTON_MENU_CATEGORIES
import ca.hankli.kinton.data.source.KINTON_MENU_ITEMS
import ca.hankli.kinton.model.MenuCategory
import ca.hankli.kinton.model.MenuItem
import ca.hankli.kinton.repository.JsonParseRepo

class MenuViewModel(private val jsonParseRepo: JsonParseRepo) : ViewModel() {

    fun getMenuCategories(): List<MenuCategory> {
        return jsonParseRepo.parseKintonMenuCategories(KINTON_MENU_CATEGORIES) ?: emptyList()
    }

    fun getMenuItemGroups(): Map<Int, List<MenuItem>> {
        val list = jsonParseRepo.parseKintonMenuItems(KINTON_MENU_ITEMS) ?: emptyList()
        return if (list.isEmpty()) emptyMap() else list.groupBy { it.type }
    }
}