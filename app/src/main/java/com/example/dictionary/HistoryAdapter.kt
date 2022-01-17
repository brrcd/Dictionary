package com.example.dictionary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.HistoryRvItemBinding
import com.example.dictionary.model.DataModel

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.CustomViewHolder>() {

    private var data: List<DataModel> = listOf()

    fun setData(data: List<DataModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class CustomViewHolder(private val binding: HistoryRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(data: DataModel) = with(binding){
                historyWord.text = data.text
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder =
        CustomViewHolder(
            HistoryRvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}