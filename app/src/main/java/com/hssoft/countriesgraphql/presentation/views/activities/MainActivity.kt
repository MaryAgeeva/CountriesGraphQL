package com.hssoft.countriesgraphql.presentation.views.activities

import android.os.Bundle
import com.hssoft.countriesgraphql.R
import com.hssoft.countriesgraphql.presentation.ContinentClickListener
import com.hssoft.countriesgraphql.presentation.extensions.addFragment
import com.hssoft.countriesgraphql.presentation.extensions.addFragmentWithBackstack
import com.hssoft.countriesgraphql.presentation.views.fragments.ContinentsFragment
import com.hssoft.countriesgraphql.presentation.views.fragments.CountriesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), ContinentClickListener {

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(ContinentsFragment.newInstance(), R.id.main_frame)
    }

    override fun onClick(code: String) {
        if(main_detail_frame != null)
            addFragment(CountriesFragment.newInstance(code), R.id.main_detail_frame)
        else addFragmentWithBackstack(CountriesFragment.newInstance(code), R.id.main_frame)
    }
}
