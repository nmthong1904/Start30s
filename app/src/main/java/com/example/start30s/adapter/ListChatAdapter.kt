package com.example.start30s.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.start30s.R
import com.example.start30s.model.ChatObject

class ListChatAdapter() : RecyclerView.Adapter<ListChatAdapter.ViewHolder>() {
    private lateinit var mListUser: MutableList<ChatObject>

    fun setData(list: MutableList<ChatObject>) {
        this.mListUser = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user_chat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val chatObject: ChatObject = mListUser[position] ?: return
        holder.tvName.text = chatObject.nameChat.toString()
        holder.tvChat.text = chatObject.chatChat.toString()
//        holder.tvChat.text = "nhat anh"
        holder.imgAvt.setImageResource(R.drawable.itemdetail2)
    }

    override fun getItemCount(): Int {
        if (mListUser != null) {
            return mListUser.size
        }
        return 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView
        val tvChat: TextView
        val imgAvt: ImageView

        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvChat = itemView.findViewById(R.id.tvChat)
            imgAvt = itemView.findViewById(R.id.img_avt)
        }
    }
}