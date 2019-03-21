package com.hssoft.countriesgraphql.presentation.views.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.hssoft.countriesgraphql.R
import com.hssoft.countriesgraphql.domain.exceptions.Failure
import com.hssoft.countriesgraphql.presentation.ContinentClickListener
import com.hssoft.countriesgraphql.presentation.extensions.gone
import com.hssoft.countriesgraphql.presentation.extensions.subscribe
import com.hssoft.countriesgraphql.presentation.extensions.visible
import com.hssoft.countriesgraphql.presentation.view_models.ContinentsViewModel
import com.hssoft.countriesgraphql.presentation.views.adapters.ContinentsAdapter
import kotlinx.android.synthetic.main.continents_fragment.*
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.koin.viewModel

class ContinentsFragment : BaseFragment() {

    private val viewModel: ContinentsViewModel by currentScope.viewModel(this)
    private val continentsAdapter = ContinentsAdapter { (activity as? ContinentClickListener)?.onClick(it) }

    override fun getViewResource(): Int = R.layout.continents_fragment

    override fun getSimpleTag(): String = TAG

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        continents_rv.apply {
            adapter = continentsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        continents_rv_layout.setOnRefreshListener {
            if(viewModel.data.value?.isEmpty() == true)
                viewModel.getAllItems()
            else continents_rv_layout.isRefreshing = false
        }
        viewModel.data.subscribe(this) {
            continentsAdapter.items = it
            dataReceived()
        }
        viewModel.failures.subscribe(this) {
            when(it) {
                is Failure.NoDataFailure, Failure.ServerFailure -> errorReceivingData()
                is Failure.NoNetworkFailure -> {
                    errorReceivingData()
                    showToast(resources.getString(R.string.general_no_internet))
                }
            }
        }
        viewModel.getAllItems()
    }

    private fun errorReceivingData() {
        continents_rv.gone()
        continents_no_data_group.visible()
    }

    private fun dataReceived() {
        continents_rv.visible()
        continents_no_data_group.gone()
    }

    companion object {
        const val TAG = "CONTINENTS_TAG"

        fun newInstance() = ContinentsFragment()
    }
}
