package ca.hankli.kinton.ui.main.menu

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import ca.hankli.kinton.R
import ca.hankli.kinton.ui.util.BaseFragment
import ca.hankli.kinton.ui.util.MarginItemDecoration
import kotlinx.android.synthetic.main.fragment_menu.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuFragment : BaseFragment() {

    override val layoutRes: Int
        get() = R.layout.fragment_menu

    override val hasOptionsMenu: Boolean
        get() = true

    override val menuRes: Int
        get() = R.menu.search

    private val viewModel: MenuViewModel by viewModel()

    private val adapter: MenuAdapter = MenuAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.menu_list.apply {
            setHasFixedSize(true)
            adapter = this@MenuFragment.adapter
            addItemDecoration(
                MarginItemDecoration(resources.getDimension(R.dimen.padding_size_12).toInt())
            )
        }

        adapter.apply {
            categories = viewModel.getMenuCategories()
            itemGroups = viewModel.getMenuItemGroups()
            notifyDataSetChanged()
        }
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