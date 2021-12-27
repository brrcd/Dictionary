package com.example.dictionary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.RvItemBinding

class Adapter : RecyclerView.Adapter<Adapter.CustomViewHolder>() {

    private var data: List<DataModel> = listOf()

    fun setData(data : List<DataModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class CustomViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataModel){
            binding.word.text = data.text
            binding.word.text = data.meanings?.get(0)?.translation?.translation
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            RvItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}