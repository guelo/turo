package com.miguel.turotakehome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.miguel.data.Business
import com.miguel.turotakehome.databinding.BusinessRowBinding

internal class BusinessAdapter(
    private val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<ViewHolder>() {

    private val businesses = mutableListOf<Business>()

    fun replace(newList: List<Business>) {
        businesses.clear()
        businesses.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(BusinessRowBinding.inflate(layoutInflater, parent, false))

    override fun getItemCount() = businesses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(businesses[position])
    }
}

internal class ViewHolder(
    private val binding: BusinessRowBinding
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.card.setOnClickListener {
            binding.card.isChecked = !binding.card.isChecked
        }
    }
    fun bind(biz: Business) {
        binding.imageView.load(biz.imageUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_baseline_image_24)
        }

        binding.name.text = biz.name
        binding.address.text = biz.address
        binding.phone.text = biz.phone
    }
}