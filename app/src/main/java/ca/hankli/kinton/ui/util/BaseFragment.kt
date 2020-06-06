package ca.hankli.kinton.ui.util

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.annotation.LayoutRes
import androidx.annotation.MenuRes
import androidx.fragment.app.Fragment
import ca.hankli.kinton.util.NO_RESOURCE

open class BaseFragment : Fragment {

    constructor() : super()

    constructor(
        @LayoutRes layoutId: Int,
        hasOptionsMenu: Boolean = false,
        @MenuRes menuRes: Int = NO_RESOURCE
    ) : super(layoutId) {
        this.hasMenu = hasOptionsMenu
        this.menuRes = menuRes
    }

    private var hasMenu = false

    @MenuRes
    private var menuRes: Int = NO_RESOURCE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(hasMenu)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if (menuRes != NO_RESOURCE) inflater.inflate(menuRes, menu)
    }
}