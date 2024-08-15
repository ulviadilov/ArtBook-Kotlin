package com.example.artbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artbook.databinding.RecyclerRowBinding

class ArtAdapter(val artlist: ArrayList<Art>) : RecyclerView.Adapter<ArtAdapter.ArtHolder>() {
    class ArtHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtHolder(binding)
    }

    override fun getItemCount(): Int {
        return artlist.size
    }

    override fun onBindViewHolder(holder: ArtHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = artlist.get(position).name
        holder.itemView.setOnClickListener{
            val intent  = Intent(holder.itemView.context, ArtAdapter :: class.java)
            intent.putExtra("info","old")
            intent.putExtra("id",artlist.get(position).id)
            holder.itemView.context.startActivity(intent)
        }
    }
}