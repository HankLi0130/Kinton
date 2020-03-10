package ca.hankli.kinton.ui.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import ca.hankli.kinton.R
import ca.hankli.kinton.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_menu.view.*

class MenuFragment : BaseFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_menu

    private val viewModel: MenuViewModel by viewModels()

    private val adapter: MenuAdapter = MenuAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.menu_list.apply {
            setHasFixedSize(true)
            adapter = this@MenuFragment.adapter
        }

        adapter.items = viewModel.items
    }
}