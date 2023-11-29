package com.eyalya.test.asiotech.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.eyalya.test.asiotech.databinding.ItemBagBinding
import com.eyalya.test.asiotech.models.Bag

class BagsAdapter(private val bagsList: ArrayList<Bag> = arrayListOf()): RecyclerView.Adapter<BagsAdapter.BagDetailsViewHolder>() {

    override fun getItemCount(): Int = bagsList.size
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BagDetailsViewHolder {
        val binding = ItemBagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BagDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BagDetailsViewHolder, position: Int) {
        holder.bind(bagsList[position])
    }

    inner class BagDetailsViewHolder(private val binding: ItemBagBinding): ViewHolder(binding.root) {

        init {

        }

        fun bind(bag: Bag) = with(binding) {

        }

    }
}