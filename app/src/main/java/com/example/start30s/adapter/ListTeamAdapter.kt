package com.example.start30s.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.start30s.R

class ListTeamAdapter(
    private val nameTeam: List<String>?,
    private val images: List<Int>,
    private val context: Context,
    private val controller: NavController
) : RecyclerView.Adapter<ListTeamAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.tv_team.text = nameTeam!![position]
        holder.img_team.setImageResource(images[position])
        holder.layoutCardView?.setOnClickListener {
            val nameOneTeam: String = nameTeam[position]
            val bundle = Bundle()
            bundle.putString("nameOneTeam", nameOneTeam)
            controller.navigate(R.id.action_teamFragment_to_teamDetailFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return nameTeam?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_team: TextView
        val tv_binh_chon_ngay: TextView
        val img_team: ImageView
        var layoutCardView: CardView? = null

        init {
            tv_team = itemView.findViewById(R.id.tv_team)
            tv_binh_chon_ngay = itemView.findViewById(R.id.tv_binh_chon_ngay)
            img_team = itemView.findViewById(R.id.img_team)
            layoutCardView = itemView.findViewById(R.id.layoutCardView)
        }
    }
}