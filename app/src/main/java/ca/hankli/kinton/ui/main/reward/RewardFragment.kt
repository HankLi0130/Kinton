package ca.hankli.kinton.ui.main.reward

import android.Manifest
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import ca.hankli.kinton.R
import ca.hankli.kinton.ui.main.MainViewModel
import ca.hankli.kinton.ui.util.BaseFragment
import ca.hankli.kinton.util.REQUEST_PERMISSION
import ca.hankli.kinton.util.arePermissionsGranted
import ca.hankli.kinton.util.extension.askForPermissions
import ca.hankli.kinton.util.extension.visit
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_reward.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RewardFragment : BaseFragment() {

    override val layoutRes: Int
        get() = R.layout.fragment_reward

    override val hasOptionsMenu: Boolean
        get() = true

    override val menuRes: Int
        get() = R.menu.social_meida

    private val viewModel: RewardViewModel by viewModel()

    private val sharedViewModel: MainViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view_scan.setOnClickListener {
            askForPermissions(arrayOf(Manifest.permission.CAMERA), REQUEST_PERMISSION) {
                showScanner()
            }
        }

        sharedViewModel.scanEvent.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandle()?.let { json ->
                viewModel.handleJson(json)
            }
        })

        viewModel.snackbarEvent.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandle()?.let { message ->
                Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
            }
        })
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
        findNavController().navigate(R.id.scan_dest)
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