package ca.hankli.kinton.ui.main.reward

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.hankli.kinton.R
import ca.hankli.kinton.model.RewardItem
import ca.hankli.kinton.ui.util.BaseViewHolder
import ca.hankli.kinton.util.extension.viewOf
import kotlinx.android.synthetic.main.view_holder_row_2.view.*

class RewardAdapter : RecyclerView.Adapter<RewardItemViewHolder>() {

    var items: List<RewardItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardItemViewHolder {
        return RewardItemViewHolder(parent.viewOf(R.layout.view_holder_row_2))
    }

    override fun onBindViewHolder(holder: RewardItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class RewardItemViewHolder(itemView: View) : BaseViewHolder<RewardItem>(itemView) {

    override fun bind(item: RewardItem) {
        with(itemView) {
            view_icon.setImageResource(item.iconRes)
            view_title.text = item.title
            view_subtitle_1.text =
                context.getString(R.string.requested_points, item.requestedPoints)
            view_subtitle_2.text = context.getString(R.string.minimum_bowls, item.minimumBowls)
        }
    }
}
