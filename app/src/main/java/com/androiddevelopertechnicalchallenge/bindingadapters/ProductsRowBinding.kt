package com.androiddevelopertechnicalchallenge.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.androiddevelopertechnicalchallenge.R

class ProductsRowBinding {

    companion object {
//        @BindingAdapter("onItunesHolderClickListener")
//        @JvmStatic
//        fun onItunesHolderClickListener(itunesRowLayout: ConstraintLayout, result: Result) {
//            Log.d("onItunesHolderClickListener", "Called!")
//            itunesRowLayout.setOnClickListener {
//                try {
//                    val action = HomeFragmentDirections.actionHomeFragmentToDetailsActivity(result)
//                    itunesRowLayout.findNavController().navigate(action)
//                }catch (e: Exception) {
//                    Log.d("onItunesHolderClickListener", e.toString())
//                }
//            }
//        }

        @BindingAdapter("loadImageFromUrl")
        @JvmStatic
        fun loadImageFromUrl(imageView: ImageView, imageUrl: String?){
            imageView.load(imageUrl) {
                crossfade(600)
                error(R.drawable.image_error_placeholder)
            }
        }

//        @BindingAdapter("setTrackPrice")
//        @JvmStatic
//        fun setTrackPrice(textView: TextView, price: Double){
//            textView.text = price.toString()
//        }
    }
}