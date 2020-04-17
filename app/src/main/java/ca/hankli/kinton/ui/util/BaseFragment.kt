package ca.hankli.kinton.ui.util

import android.os.Bundle
import android.view.*
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.fragment.app.Fragment
import ca.hankli.kinton.util.NO_RESOURCE

open class BaseFragment : Fragment() {

    @LayoutRes
    protected open val layoutRes: Int = NO_RESOURCE

    protected open val hasOptionsMenu = false

    @MenuRes
    protected open val menuRes: Int = NO_RESOURCE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(hasOptionsMenu)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (layoutRes == NO_RESOURCE) {
            super.onCreateView(inflater, container, savedInstanceState)
        } else {
            inflater.inflate(layoutRes, container, false)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (menuRes == NO_RESOURCE) return else inflater.inflate(menuRes, menu)
    }
}