package com.example.start30s.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.start30s.R

class ListRankAdapter(
    private val listName: List<String>?,
    private val listSoLuotBauChon: List<String>
) : RecyclerView.Adapter<ListRankAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_rank, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.tvId.text = "#" + (position + 1).toString()
        holder.tvName.text = listName!![position]
        holder.tvLuotBauChon.text = listSoLuotBauChon[position]
        holder.tvStarNum.text = (listName.size - position).toString()

    }

    override fun getItemCount(): Int {
        return listName?.size!!
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView
        val tvName: TextView
        val tvLuotBauChon: TextView
        val tvStarNum: TextView

        init {
            tvId = itemView.findViewById(R.id.tvId)
            tvName = itemView.findViewById(R.id.tvName)
            tvLuotBauChon = itemView.findViewById(R.id.tvLuotBauChon)
            tvStarNum = itemView.findViewById(R.id.tvStarNum)
        }
    }
}