package ca.hankli.kinton.ui.main.reward

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.hankli.kinton.R
import ca.hankli.kinton.model.RewardItem
import ca.hankli.kinton.ui.util.BaseViewHolder
import kotlinx.android.synthetic.main.view_holder_row_2.view.*

class RewardAdapter : RecyclerView.Adapter<RewardItemViewHolder>() {

    var items: List<RewardItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_row_2, parent, false)
        return RewardItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RewardItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class RewardItemViewHolder(view: View) : BaseViewHolder<RewardItem>(view) {

    override fun bind(item: RewardItem) {
        itemView.apply {
            icon.setImageResource(item.iconRes)
            title.text = item.title
            subtitle.text = item.requestedPoints.toString()
        }
    }
}