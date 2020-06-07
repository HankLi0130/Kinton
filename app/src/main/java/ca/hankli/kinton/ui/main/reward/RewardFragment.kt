package ca.hankli.kinton.ui.main.reward

import android.Manifest
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import ca.hankli.kinton.R
import ca.hankli.kinton.ui.main.MainViewModel
import ca.hankli.kinton.ui.util.BaseFragment
import ca.hankli.kinton.ui.util.MarginItemDecoration
import ca.hankli.kinton.util.REQUEST_PERMISSION
import ca.hankli.kinton.util.arePermissionsGranted
import ca.hankli.kinton.util.extension.askForPermissions
import ca.hankli.kinton.util.extension.visit
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.card_eaten_bowls.*
import kotlinx.android.synthetic.main.fragment_reward.*
import kotlinx.android.synthetic.main.view_holder_label_1.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RewardFragment : BaseFragment(R.layout.fragment_reward, true, R.menu.social_meida) {

    private val viewModel: RewardViewModel by viewModel()

    private val sharedViewModel: MainViewModel by sharedViewModel()

    private val adapter = RewardAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.notifyUIKintonBowlerInfo()

        view_scan.setOnClickListener {
            askForPermissions(arrayOf(Manifest.permission.CAMERA), REQUEST_PERMISSION) {
                showScanner()
            }
        }

        sharedViewModel.scanEvent.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandle()?.let { json ->
                viewModel.handleScanResult(json)
            }
        })

        viewModel.snackbarEvent.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandle()?.let { message ->
                Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
            }
        })

        viewModel.kintonBowlerInfo.observe(viewLifecycleOwner, Observer {
            view_bowls.text = getString(R.string.total_number_of_bowls, it.totalNumberOfBowls)

            view_badge_10.isVisible = it.totalNumberOfBowls >= 10
            view_badge_30.isVisible = it.totalNumberOfBowls >= 30
            view_badge_50.isVisible = it.totalNumberOfBowls >= 50
            view_badge_100.isVisible = it.totalNumberOfBowls >= 100

            view_points.text = getString(R.string.total_number_of_points, it.availablePoints)
        })

        view_reward_list.apply {
            setHasFixedSize(true)
            adapter = this@RewardFragment.adapter
            addItemDecoration(
                MarginItemDecoration(resources.getDimension(R.dimen.padding_size_12).toInt())
            )
        }

        adapter.apply {
            items = viewModel.getRewardItems()
            notifyDataSetChanged()
        }

        label.text = getString(R.string.title_reward)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_PERMISSION -> {
                if (arePermissionsGranted(grantResults)) {
                    showScanner()
                } else {
                    showPermissionDenied()
                }
            }
        }
    }

    private fun showScanner() {
        findNavController().navigate(R.id.action_reward_dest_to_scan_dest)
    }

    private fun showPermissionDenied() {
        Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT).show()
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