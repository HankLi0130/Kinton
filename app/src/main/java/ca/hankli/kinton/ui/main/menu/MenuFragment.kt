package ca.hankli.kinton.ui.main.menu

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import ca.hankli.kinton.R
import ca.hankli.kinton.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_menu.view.*

class MenuFragment : BaseFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_menu

    override val hasOptionsMenu: Boolean
        get() = true

    private val viewModel: MenuViewModel by viewModels()

    private val adapter: MenuAdapter = MenuAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.menu_list.apply {
            setHasFixedSize(true)
            adapter = this@MenuFragment.adapter
        }

        adapter.apply {
            categories = viewModel.getMenuCategories(this@MenuFragment.requireContext())
            itemGroups = viewModel.getMenuItemGroups(this@MenuFragment.requireContext())
            notifyDataSetChanged()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                // TODO search specific items
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}