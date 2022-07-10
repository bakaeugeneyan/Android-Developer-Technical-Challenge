package com.androiddevelopertechnicalchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.androiddevelopertechnicalchallenge.R
import com.androiddevelopertechnicalchallenge.adapter.ProductsCategoryRecycleViewAdapter
import com.androiddevelopertechnicalchallenge.adapter.ProductsRecycleViewAdapter
import com.androiddevelopertechnicalchallenge.databinding.ActivityDetailsBinding
import com.androiddevelopertechnicalchallenge.databinding.FragmentHomeBinding
import com.androiddevelopertechnicalchallenge.model.ProductDTO
import com.androiddevelopertechnicalchallenge.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_details.*

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private val args by navArgs<DetailsActivityArgs>()
    private val mAdapter by lazy { ProductsCategoryRecycleViewAdapter() }
    private var binding: ActivityDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Details"

        val args = args
        val myBundle: ProductDTO.Product = args?.state
        binding!!.productImageView.load(myBundle?.thumbnail)
        binding!!.titleTextView.text = myBundle?.title
        binding!!.priceTextView.text = "₱ " + myBundle?.price.toString()
        binding!!.descriptionTextView.text = myBundle?.description

        setupRecycleView()
    }

    private fun setupRecycleView() {
        binding!!.categoryRecycleView.adapter = mAdapter
        binding!!.categoryRecycleView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}