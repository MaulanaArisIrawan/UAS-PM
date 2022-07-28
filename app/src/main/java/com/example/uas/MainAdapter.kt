package com.example.uas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uas.data.ResponseApi
import com.example.uas.databinding.ItemLayoutBinding

class MainAdapter(
    private val click: (ResponseApi.ResponseApiItem) -> Unit,
    private val data: MutableList<ResponseApi.ResponseApiItem> = mutableListOf()
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    class MainViewHolder(private val v: ItemLayoutBinding) : RecyclerView.ViewHolder(v.root) {
        fun bind(model: ResponseApi.ResponseApiItem) {
            v.title.text = model.title
            v.des.text = model.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            click(data[position])
        }
    }

    fun setData(data: MutableList<ResponseApi.ResponseApiItem>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}