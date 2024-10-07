package com.gcyazilim.traveldesigntutorial.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gcyazilim.traveldesigntutorial.databinding.ViewholderPopularBinding
import com.gcyazilim.traveldesigntutorial.base.models.ItemModel
import com.gcyazilim.traveldesigntutorial.view.HomeFragmentDirections

class PopularAdapter() : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {
    class PopularViewHolder(val binding: ViewholderPopularBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding =
            ViewholderPopularBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val model = differ.currentList[position]
        holder.binding.popular = model
        holder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(model)
            Navigation.findNavController(it).navigate(action)
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<ItemModel>() {
        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}