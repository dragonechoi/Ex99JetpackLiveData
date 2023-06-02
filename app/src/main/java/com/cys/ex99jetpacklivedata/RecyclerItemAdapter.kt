package com.cys.ex99jetpacklivedata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cys.ex99jetpacklivedata.databinding.RecyclerItemBinding


class RecyclerItemAdapter(val items: List<Item>) : RecyclerView.Adapter<RecyclerItemAdapter.VH>() {

    inner class VH(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding: RecyclerItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_item,
            parent,
            false
        )
        return VH(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.item = items[position]
    }
}