package com.example.start30s.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.start30s.R

class ListTeamDetailAdapter
    (
    private val listNameTeamDetail: List<String>?,
    private val listImagesDetail: List<Int>,
    private val context: Context) : RecyclerView.Adapter<ListTeamDetailAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_detail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.tvTeam.text = listNameTeamDetail!![position]
        holder.imgTeam.setImageResource(listImagesDetail[position])
        holder.layoutCardView?.setOnClickListener {
//            var nameTeam: String = nameTeam!![position]
//            var intent: Intent = Intent(context, TeamDetailActivity::class.java)
//            val bundle = Bundle()
//            bundle.putString("nameTeam", nameTeam)
//            intent.putExtra("data", bundle)
//            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listNameTeamDetail?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTeam: TextView
        val tvBauChon: TextView
        val imgTeam: ImageView
        var layoutCardView: CardView? = null

        init {
            tvTeam = itemView.findViewById(R.id.tv_team)
            tvBauChon = itemView.findViewById(R.id.tv_binh_chon_ngay)
            imgTeam = itemView.findViewById(R.id.img_team)
            layoutCardView = itemView.findViewById(R.id.layoutCardView)
        }
    }
}