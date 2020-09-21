package com.servinf.androidstack.ui.notifications

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.servinf.androidstack.R
import com.servinf.androidstack.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_notifications.*
import org.koin.android.viewmodel.ext.android.viewModel

class NotificationsFragment : BaseFragment() {

    private val notificationsViewModel: NotificationsViewModel by viewModel()

    override fun layoutRes(): Int = R.layout.fragment_notifications

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer { text ->
            if (text != null)
                txtNotifications.text = text
        })
    }
}
