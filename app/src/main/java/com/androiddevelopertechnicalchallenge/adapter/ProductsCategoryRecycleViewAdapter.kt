package com.androiddevelopertechnicalchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androiddevelopertechnicalchallenge.databinding.LayoutProductCategoryListItemHolderBinding

class ProductsCategoryRecycleViewAdapter :
    RecyclerView.Adapter<ProductsCategoryRecycleViewAdapter.ProductCategoryViewHolder>() {

    private var category = arrayListOf(
        "smartphones",
        "laptops",
        "fragrances",
        "skincare",
        "groceries",
        "home-decoration",
        "furniture",
        "tops",
        "womens-dresses",
        "womens-shoes",
        "mens-shirts",
        "mens-shoes",
        "mens-watches",
        "womens-watches",
        "womens-bags",
        "womens-jewellery",
        "sunglasses",
        "automotive",
        "motorcycle",
        "lighting"
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsCategoryRecycleViewAdapter.ProductCategoryViewHolder {
        return ProductCategoryViewHolder(
            LayoutProductCategoryListItemHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ProductsCategoryRecycleViewAdapter.ProductCategoryViewHolder,
        position: Int
    ) {
        holder.binding.categoryItemTextView.text = category[position]
    }

    override fun getItemCount(): Int {
        return category.size
    }

    inner class ProductCategoryViewHolder(val binding: LayoutProductCategoryListItemHolderBinding) :
        RecyclerView.ViewHolder(binding.root)
}