package ca.hankli.kinton.util.extension

import androidx.fragment.app.Fragment

fun Fragment.visit(uri: String) = activity?.visit(uri)
