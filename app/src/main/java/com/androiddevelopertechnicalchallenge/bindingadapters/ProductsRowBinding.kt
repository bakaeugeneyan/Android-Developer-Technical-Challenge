package com.androiddevelopertechnicalchallenge.bindingadapters

import android.util.Log
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import coil.load
import com.androiddevelopertechnicalchallenge.R
import com.androiddevelopertechnicalchallenge.model.ProductDTO
import com.androiddevelopertechnicalchallenge.ui.HomeFragmentDirections

class ProductsRowBinding {

    companion object {
        @BindingAdapter("onProductsHolderClickListener")
        @JvmStatic
        fun onProductsHolderClickListener(productRowLayout: ConstraintLayout, state: ProductDTO.Product) {
            Log.d("onProductsHolderClickListener", "Called!")
            productRowLayout.setOnClickListener {
                try {
                    val action = HomeFragmentDirections.actionHomeFragmentToDetailsActivity(state)
                    productRowLayout.findNavController().navigate(action)
                }catch (e: Exception) {
                    Log.d("onProductsHolderClickListener", e.toString())
                }
            }
        }

        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String?){
            imageView.load(imageUrl) {
                crossfade(600)
                error(R.drawable.image_error_placeholder)
            }
        }
    }
}