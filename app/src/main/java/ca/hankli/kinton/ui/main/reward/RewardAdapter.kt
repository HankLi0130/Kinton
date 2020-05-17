package ca.hankli.kinton.ui.main.reward

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.hankli.kinton.R
import ca.hankli.kinton.util.extension.viewOf
import kotlinx.android.synthetic.main.card_eaten_bowls.view.*

class RewardAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> EatenBowlsCard(parent.viewOf(R.layout.card_eaten_bowls))
            else -> throw IllegalArgumentException("Not support this view type.")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (position) {
            0 -> {
                if (holder is EatenBowlsCard) {
                    holder.bind(107)
                }
            }
        }
    }

    override fun getItemCount(): Int = 1
}

private class EatenBowlsCard(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(count: Int) {
        with(itemView) {
            view_title.text = context.getString(R.string.total_number_of_bowls, count)
        }
    }
}
