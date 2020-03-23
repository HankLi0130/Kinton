package ca.hankli.kinton.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.hankli.kinton.R
import ca.hankli.model.MenuItem
import kotlinx.android.synthetic.main.item_menu_style_1.view.*

class MenuAdapter : RecyclerView.Adapter<MenuViewHolder>() {

    var items: List<MenuItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu_style_1, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: MenuItem) {
        itemView.apply {
            icon.setImageResource(item.iconRes)
            title.text = item.title
            subtitle.text = item.subtitle
            price.text = item.price.toString()
        }
    }
}
