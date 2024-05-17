package com.gorillalogic.workshoplayout.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gorillalogic.workshoplayout.R
import com.gorillalogic.workshoplayout.model.ItemModel

class HomeAdapter(private val listener: (ItemModel) -> Unit) :
    ListAdapter<ItemModel, RecyclerView.ViewHolder>(HomeAdapterDiffCallback)
{
    //region - View Holder
    class HomeItemViewHolder(private var parent: View) : RecyclerView.ViewHolder(parent) {

        // Get reference to UI views
        private val itemImageView: ImageView = parent.findViewById(R.id.item_image)
        private val itemTitleView: TextView = parent.findViewById(R.id.item_title)
        private val descriptionView: TextView = parent.findViewById(R.id.item_description)

        // Bind data with views
        fun bind(item: ItemModel, listener: (ItemModel) -> Unit) {
            parent.setOnClickListener { listener(item) }
            itemImageView.setImageResource(item.imageResourceId)
            itemTitleView.setText(item.titleId)
            descriptionView.setText(item.descriptionId)
        }
    }
    //endregion

    //region - ListAdapter implementation
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.home_item, parent, false)
        return HomeItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemData = getItem(position)
        (holder as HomeItemViewHolder).bind(itemData, listener)
    }
    //endregion

    //region - Companion DiffCallback implementation
    companion object HomeAdapterDiffCallback : DiffUtil.ItemCallback<ItemModel>() {

        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.imageResourceId == newItem.imageResourceId &&
                    oldItem.titleId == newItem.titleId &&
                    oldItem.descriptionId == newItem.descriptionId
        }

        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.imageResourceId == newItem.imageResourceId &&
                    oldItem.titleId == newItem.titleId &&
                    oldItem.descriptionId == newItem.descriptionId
        }
    }
    //endregion
}