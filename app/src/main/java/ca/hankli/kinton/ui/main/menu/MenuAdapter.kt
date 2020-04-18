package ca.hankli.kinton.ui.main.menu

import android.view.View
import android.view.ViewGroup
import ca.hankli.kinton.R
import ca.hankli.kinton.model.MenuCategory
import ca.hankli.kinton.model.MenuItem
import ca.hankli.kinton.ui.util.BaseViewHolder
import ca.hankli.kinton.ui.util.SectionAdapter
import ca.hankli.kinton.util.extension.viewOf
import kotlinx.android.synthetic.main.view_holder_label_1.view.*
import kotlinx.android.synthetic.main.view_holder_row_1.view.*
import kotlinx.android.synthetic.main.view_holder_row_1.view.icon

class MenuAdapter : SectionAdapter<MenuCategoryViewHolder, MenuItemViewHolder>() {

    var categories: List<MenuCategory> = emptyList()

    var itemGroups: Map<Int, List<MenuItem>> = emptyMap()

    override fun onCreateLabelViewHolder(parent: ViewGroup): MenuCategoryViewHolder {
        val view = parent.viewOf(R.layout.view_holder_label_1)
        return MenuCategoryViewHolder(view)
    }

    override fun onCreateRowViewHolder(parent: ViewGroup): MenuItemViewHolder {
        val view = parent.viewOf(R.layout.view_holder_row_1)
        return MenuItemViewHolder(view)
    }

    override fun onBindLabelViewHolder(holder: MenuCategoryViewHolder, labelPosition: Int) {
        holder.bind(categories[labelPosition])
    }

    override fun onBindRowViewHolder(
        holder: MenuItemViewHolder,
        labelPosition: Int,
        rowPosition: Int
    ) {
        val key = categories[labelPosition].type
        val item = itemGroups.getValue(key)[rowPosition]
        holder.bind(item)
    }

    override fun getLabelCount(): Int = categories.size

    override fun getRowCountInSection(labelPosition: Int): Int {
        val key = categories[labelPosition].type
        return itemGroups.getValue(key).size
    }
}

class MenuCategoryViewHolder(view: View) : BaseViewHolder<MenuCategory>(view) {

    override fun bind(item: MenuCategory) {
        itemView.apply {
            icon.setImageResource(item.iconRes)
            label.text = item.name
        }
    }
}

class MenuItemViewHolder(view: View) : BaseViewHolder<MenuItem>(view) {

    override fun bind(item: MenuItem) {
        itemView.apply {
            icon.setImageResource(item.iconRes)
            title.text = item.title
            subtitle.text = item.subtitle
            price.text = item.price.toString()
        }
    }
}
