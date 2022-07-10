package com.androiddevelopertechnicalchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.androiddevelopertechnicalchallenge.databinding.LayoutProductListItemHolderBinding
import com.androiddevelopertechnicalchallenge.model.ProductDTO
import com.androiddevelopertechnicalchallenge.utils.ProductsDiffUtil

class ProductsRecycleViewAdapter : RecyclerView.Adapter<ProductsRecycleViewAdapter.ProductViewHolder>() {

    private var products = emptyList<ProductDTO.Product>()

    class ProductViewHolder(private val binding: LayoutProductListItemHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(state: ProductDTO.Product){
            binding.state = state
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ProductViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutProductListItemHolderBinding.inflate(layoutInflater, parent, false)
                return  ProductViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return  ProductViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       val currentProducts = products[position]
        holder.bind(currentProducts)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun setData(newData: ProductDTO) {
        val productsDiffUtil = ProductsDiffUtil(products, newData.products)
        val diffUtilResult = DiffUtil.calculateDiff(productsDiffUtil)
        products = newData.products
        diffUtilResult.dispatchUpdatesTo(this)

//        products = newData.products
//        notifyDataSetChanged()
    }
}