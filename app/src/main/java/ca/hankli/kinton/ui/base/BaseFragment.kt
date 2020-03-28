package ca.hankli.kinton.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import ca.hankli.kinton.util.NO_RESOURCE

open class BaseFragment : Fragment() {

    @LayoutRes
    protected open val layoutId = NO_RESOURCE

    protected open val hasOptionsMenu = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(hasOptionsMenu)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (layoutId == NO_RESOURCE) {
            super.onCreateView(inflater, container, savedInstanceState)
        } else {
            inflater.inflate(layoutId, container, false)
        }
    }
}