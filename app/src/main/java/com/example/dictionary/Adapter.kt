package com.example.dictionary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.RvItemBinding
import com.example.model.DataModel

class Adapter(private val delegate: (item: DataModel) -> Unit) : RecyclerView.Adapter<Adapter.CustomViewHolder>() {

    private var data: List<DataModel> = listOf()

    fun setData(data: List<DataModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class CustomViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataModel, delegateFunction: (item: DataModel) -> Unit) = with(binding) {
            word.text = data.text
            word.text = data.meanings[0].translation?.translation
            itemView.setOnClickListener {
                delegateFunction.invoke(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder =
        CustomViewHolder(
            RvItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(data[position], delegate)
    }

    override fun getItemCount(): Int = data.size
}