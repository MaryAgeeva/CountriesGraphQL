package com.hssoft.countriesgraphql.presentation.views.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.hssoft.countriesgraphql.R
import com.hssoft.countriesgraphql.domain.extensions.emptyString
import com.hssoft.countriesgraphql.presentation.extensions.subscribe
import com.hssoft.countriesgraphql.presentation.view_models.CountriesViewModel
import com.hssoft.countriesgraphql.presentation.views.adapters.CountriesAdapter
import kotlinx.android.synthetic.main.countries_fragment.*
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.koin.viewModel

class CountriesFragment : BaseFragment() {

    private val viewModel: CountriesViewModel by currentScope.viewModel(this)
    private val countriesAdapter = CountriesAdapter()
    private val code by lazy {
        arguments?.getString(ITEM_CODE)?: emptyString()
    }

    override fun getViewResource(): Int = R.layout.countries_fragment

    override fun getSimpleTag(): String = TAG

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countries_rv.apply {
            adapter = countriesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        viewModel.data.subscribe(this) {
            countries_title.text = it.name
            countriesAdapter.items = it.countries
        }
        viewModel.failures.subscribe(this) {}
        viewModel.getCountries(code)
    }

    companion object {

        private const val ITEM_CODE = "ITEM_CODE"

        const val TAG = "COUNTRIES_TAG"

        fun newInstance(code: String) = CountriesFragment().apply {
            arguments = Bundle().apply {
                putString(ITEM_CODE, code)
            }
        }
    }
}
