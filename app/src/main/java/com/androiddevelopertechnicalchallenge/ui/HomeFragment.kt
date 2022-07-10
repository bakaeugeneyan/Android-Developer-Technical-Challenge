package com.androiddevelopertechnicalchallenge.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevelopertechnicalchallenge.R
import com.androiddevelopertechnicalchallenge.adapter.ProductsRecycleViewAdapter
import com.androiddevelopertechnicalchallenge.databinding.FragmentHomeBinding
import com.androiddevelopertechnicalchallenge.utils.NetworkResult
import com.androiddevelopertechnicalchallenge.viewmodel.MainViewModel
import com.androiddevelopertechnicalchallenge.viewmodel.ProductsViewModel

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private val mAdapter by lazy { ProductsRecycleViewAdapter() }
    private lateinit var mainViewModel: MainViewModel
    private lateinit var productsViewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel  = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        productsViewModel = ViewModelProvider(requireActivity())[ProductsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding!!.lifecycleOwner = this
        binding!!.state = mainViewModel

        setupRecycleView()
        requestApiData()
        return binding!!.root
    }

    private fun setupRecycleView() {
        binding!!.recyclerView.adapter = mAdapter
        binding!!.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun requestApiData() {
        mainViewModel.getProducts(productsViewModel.applyQueries())
        mainViewModel.productResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let { mAdapter.setData(it) }
                }
                is NetworkResult.Error -> {
                    Toast.makeText(
                        requireContext(),
                        response.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NetworkResult.Loading -> {
                }
            }
        }
    }
}