package ca.hankli.kinton.ui.util

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * T is the type of the items from RecyclerView.Adapter
 */

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T)
}