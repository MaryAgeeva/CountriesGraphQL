package com.hssoft.countriesgraphql.presentation.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.hssoft.countriesgraphql.presentation.views.fragments.BaseFragment

fun ViewGroup.inflateView(resource: Int) : View = LayoutInflater.from(context).inflate(resource, this, false)

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun FragmentActivity.addFragment(fragment: BaseFragment, frame: Int) {
    supportFragmentManager.beginTransaction().replace(frame, fragment)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
}

fun FragmentActivity.addFragmentWithBackstack(fragment: BaseFragment, frame: Int) {
    supportFragmentManager.beginTransaction().replace(frame, fragment)
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .addToBackStack(fragment.getSimpleTag()).commit()
}