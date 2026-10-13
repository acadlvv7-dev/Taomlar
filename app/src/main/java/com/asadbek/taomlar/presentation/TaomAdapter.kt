package com.asadbek.taomlar.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asadbek.taomlar.databinding.ItemCardMenuBinding
import com.asadbek.taomlar.domain.model.Taom
import com.bumptech.glide.Glide

class TaomAdapter(private val onItemClick: (Taom) -> Unit) : RecyclerView.Adapter<TaomAdapter.TaomViewHolder>() {
    private var taomlar: List<Taom> = emptyList()
    fun submitList(newList: List<Taom>) {
        taomlar = newList
        notifyDataSetChanged()
    }
    class TaomViewHolder(val binding: ItemCardMenuBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaomViewHolder {
        val binding = ItemCardMenuBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return TaomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaomViewHolder, position: Int) {
        val taom = taomlar[position]
        holder.binding.ovqatMenuName.text = taom.name
        Glide.with(holder.binding.imgMenu)
            .load(taom.taomlarUrl)
            .into(holder.binding.imgMenu)
        holder.binding.root.setOnClickListener {
            onItemClick(taom) }
    }

    override fun getItemCount(): Int = taomlar.size
}