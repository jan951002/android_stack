package com.servinf.androidstack.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.servinf.androidstack.R
import com.servinf.androidstack.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var dogsAdapter: DogsAdapter

    override fun layoutRes(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dogsAdapter = DogsAdapter(DogsAdapter.OnItemClickListener {
            Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
        })
        observableViewModel()
        dogsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = dogsAdapter
        }
    }

    private fun observableViewModel() {
        homeViewModel.dogs.observe(viewLifecycleOwner, Observer { dogs ->
            if (dogs != null) {
                dogsAdapter.updateData(dogs)
            }
        })

        homeViewModel.error.observe(viewLifecycleOwner, Observer { error ->
            if (error != null) {
                Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
