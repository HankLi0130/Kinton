package ca.hankli.kinton.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * L: Label ViewHolder
 * R: Row ViewHolder
 */

abstract class SectionAdapter<L : RecyclerView.ViewHolder, R : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_LABEL = 1
        private const val VIEW_TYPE_ROW = 2
    }

    private var items: Array<Item> = emptyArray()

    final override fun getItemViewType(position: Int): Int {
        return if (items[position].isLabel) VIEW_TYPE_LABEL else VIEW_TYPE_ROW
    }

    final override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_LABEL -> onCreateLabelViewHolder(parent)
            VIEW_TYPE_ROW -> onCreateRowViewHolder(parent)
            else -> throw IllegalArgumentException("Not support such view type!")
        }
    }

    final override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        items[position].run {
            if (isLabel) onBindLabelViewHolder((holder as L), this.labelPosition)
            else onBindRowViewHolder((holder as R), this.labelPosition, this.rowPosition)
        }
    }

    final override fun getItemCount(): Int {
        val list = mutableListOf<Item>()

        for (labelPosition in 0 until getLabelCount()) {
            // Add label
            list.add(Item(labelPosition))

            // Add rows
            for (rowPosition in 0 until getRowCountInSection(labelPosition)) {
                list.add(Item(labelPosition, rowPosition))
            }
        }

        items = list.toTypedArray()
        return items.size
    }

    abstract fun onCreateLabelViewHolder(parent: ViewGroup): L

    abstract fun onCreateRowViewHolder(parent: ViewGroup): R

    abstract fun onBindLabelViewHolder(holder: L, labelPosition: Int)

    abstract fun onBindRowViewHolder(
        holder: R,
        labelPosition: Int,
        rowPosition: Int
    )

    abstract fun getLabelCount(): Int

    abstract fun getRowCountInSection(labelPosition: Int): Int
}

class Item(
    val labelPosition: Int,
    val rowPosition: Int = NO_ROW_POSITION
) {
    companion object {
        const val NO_ROW_POSITION = -1
    }

    val isLabel: Boolean
        get() = rowPosition == NO_ROW_POSITION
}