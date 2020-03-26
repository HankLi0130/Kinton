package ca.hankli.kinton.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.hankli.kinton.R
import ca.hankli.kinton.model.MenuCategory
import ca.hankli.kinton.model.MenuItem
import ca.hankli.kinton.ui.adapter.SectionAdapter
import kotlinx.android.synthetic.main.view_holder_label_1.view.*
import kotlinx.android.synthetic.main.view_holder_row_1.view.*
import kotlinx.android.synthetic.main.view_holder_row_1.view.icon

class MenuAdapter : SectionAdapter<MenuCategoryViewHolder, MenuItemViewHolder>() {

    var categories: List<MenuCategory> = emptyList()

    var itemGroups: Map<Int, List<MenuItem>> = emptyMap()

    override fun onCreateLabelViewHolder(parent: ViewGroup): MenuCategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_label_1, parent, false)
        return MenuCategoryViewHolder(view)
    }

    override fun onCreateRowViewHolder(parent: ViewGroup): MenuItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_row_1, parent, false)
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

class MenuCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: MenuCategory) {
        itemView.apply {
            icon.setImageResource(item.iconRes)
            label.text = item.name
        }
    }
}

class MenuItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: MenuItem) {
        itemView.apply {
            icon.setImageResource(item.iconRes)
            title.text = item.title
            subtitle.text = item.subtitle
            price.text = item.price.toString()
        }
    }
}
