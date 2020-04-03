package ca.hankli.kinton.ui.main.reward

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import ca.hankli.kinton.R
import ca.hankli.kinton.ui.base.BaseFragment
import ca.hankli.kinton.util.extension.visit
import kotlinx.android.synthetic.main.fragment_reward.view.*

class RewardFragment : BaseFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_reward

    override val hasOptionsMenu: Boolean
        get() = true

    private val viewModel: RewardViewModel by viewModels()

    private val adapter: RewardAdapter = RewardAdapter()

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.social_meida, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.reward_list.apply {
            setHasFixedSize(true)
            adapter = this@RewardFragment.adapter
        }

        adapter.apply {
            items = viewModel.getRewardItems(this@RewardFragment.requireContext())
            notifyDataSetChanged()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_visit_facebook -> {
                visit("https://www.facebook.com/kintonramen")
                true
            }
            R.id.action_visit_instagram -> {
                visit("https://www.instagram.com/kintonramen")
                true
            }
            R.id.action_visit_twitter -> {
                visit("https://twitter.com/KintonRamen")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}