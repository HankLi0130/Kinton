package ca.hankli.kinton.ui.main.reward

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import ca.hankli.kinton.R
import ca.hankli.kinton.ui.util.BaseFragment
import ca.hankli.kinton.util.extension.visit
import kotlinx.android.synthetic.main.fragment_reward.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RewardFragment : BaseFragment() {

    override val layoutRes: Int
        get() = R.layout.fragment_reward

    override val hasOptionsMenu: Boolean
        get() = true

    override val menuRes: Int
        get() = R.menu.social_meida

    private val viewModel: RewardViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view_scan.setOnClickListener {
            Toast.makeText(requireContext(), "scan QR code", Toast.LENGTH_SHORT).show()
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