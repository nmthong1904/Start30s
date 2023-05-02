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

class ListTeamClipAdapter(
    private val ListNameTeam: List<String>?,
    private val ListImages: List<Int>,
    private val ListImagesAvt: List<Int>,
    private val ListName: List<String>?,
    private val ListHeart: List<String>?,
    private val controller: NavController,
    private var nameTeam: String
) : RecyclerView.Adapter<ListTeamClipAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_clip, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.tvTeam.text = ListNameTeam!![position]
        holder.tvName.text = ListName!![position]
        holder.tvHeart.text = ListHeart!![position]
        holder.imgAvt.setImageResource(ListImagesAvt[position])
        holder.imgTeam.setImageResource(ListImages[position])
        holder.layoutCardView.setOnClickListener {
            val nameOne: String = ListName[position]
            val bundle = Bundle()
            bundle.putString("nameOne", nameOne)
            bundle.putString("nameTeam", nameTeam)
            controller.navigate(R.id.action_teamClipFragment_to_oneClipFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return ListNameTeam?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTeam: TextView
        val tvName: TextView
        val imgTeam: ImageView
        var imgAvt: ImageView
        val tvHeart: TextView
        var layoutCardView: CardView

        init {
            tvTeam = itemView.findViewById(R.id.tv_team)
            tvName = itemView.findViewById(R.id.tv_name)
            tvHeart = itemView.findViewById(R.id.tv_heart)
            imgTeam = itemView.findViewById(R.id.img_team)
            imgAvt = itemView.findViewById(R.id.img_avt)
            layoutCardView = itemView.findViewById(R.id.layoutCardView)
        }
    }
}