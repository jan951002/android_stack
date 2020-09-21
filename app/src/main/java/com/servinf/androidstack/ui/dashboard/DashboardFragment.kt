package com.servinf.androidstack.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.servinf.androidstack.R
import com.servinf.androidstack.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.koin.android.viewmodel.ext.android.viewModel

class DashboardFragment : BaseFragment() {

    private val dashboardViewModel: DashboardViewModel by viewModel()

    override fun layoutRes(): Int = R.layout.fragment_dashboard

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer { text ->
            if (text != null)
                txtDashboard.text = text
        })
    }
}
