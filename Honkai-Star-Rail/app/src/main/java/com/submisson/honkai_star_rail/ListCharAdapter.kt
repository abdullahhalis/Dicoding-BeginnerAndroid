package com.submisson.honkai_star_rail

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.submisson.honkai_star_rail.databinding.ItemRowCharacterBinding

class ListCharAdapter(private val listChar: ArrayList<Chars>) : RecyclerView.Adapter<ListCharAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemRowCharacterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowCharacterBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listChar.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) =listChar[position]
        holder. apply {
            binding. apply {
                Glide.with(holder.itemView.context)
                    .load(photo)
                    .circleCrop()
                    .into(imgItemPhoto)
                tvItemName.text = name
                tvItemDescription.text = description
                itemView.setOnClickListener {
                    val intentDetail = Intent(itemView.context, DetailActivity::class.java)
                    intentDetail.putExtra(DetailActivity.KEY_CHARS, listChar[adapterPosition])
                    itemView.context.startActivity(intentDetail)
                }
            }
        }
    }
}