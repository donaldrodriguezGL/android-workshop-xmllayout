package com.gorillalogic.workshoplayout.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gorillalogic.workshoplayout.home.HomeAdapter
import com.gorillalogic.workshoplayout.model.ItemModel

@BindingAdapter("itemsListData")
fun bindItemsRecyclerView(recyclerView: RecyclerView, data: List<ItemModel>?) {
    val adapter = recyclerView.adapter as HomeAdapter
    adapter.submitList(data)
}

@BindingAdapter("itemImage")
fun bindItemImage(imageView: ImageView, resourceId: Int) {
    imageView.setImageResource(resourceId)
}

@BindingAdapter("itemTitle")
fun bindItemTitle(textView: TextView, resourceId: Int) {
    textView.text = textView.resources.getString(resourceId)
}

@BindingAdapter("itemDescription")
fun bindItemDescription(textView: TextView, resourceId: Int) {
    textView.text = textView.resources.getString(resourceId)
}