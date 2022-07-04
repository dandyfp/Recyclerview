package com.dandyfp.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dandyfp.recyclerview.databinding.ListItemBuahBinding
import com.dandyfp.recyclerview.model.buah

class adapterBuah
    (private val context : Context,
     private var data  : List<buah>?,
     private val itemclick:OnClickListener) : RecyclerView.Adapter<adapterBuah.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBuahBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size?:0

    inner class ViewHolder(val binding : ListItemBuahBinding) : RecyclerView.ViewHolder(binding.root){
        var  foto = binding.image
        var nama = binding.txtnama

    }
    interface OnClickListener{
        fun detailData(item : buah?)
    }
}