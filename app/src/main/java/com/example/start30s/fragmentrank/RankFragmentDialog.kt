package com.example.start30s.fragmentrank

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.start30s.adapter.ListRankAdapter
import com.example.start30s.R
import com.example.start30s.databinding.FragmentRankDialogBinding

class RankFragmentDialog : DialogFragment() {
    private lateinit var binding: FragmentRankDialogBinding
    private lateinit var listName: ArrayList<String>
    private lateinit var listLuotBauChon: ArrayList<String>
    private lateinit var listRankAdapter: ListRankAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rank_dialog, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listName = ArrayList()
        listLuotBauChon = ArrayList()

        listName.add("Team Park Min Young")
        listName.add("Team Ha Ji Won")
        listName.add("Team Song Hye Kyo")
        listName.add("Team Park Shin Hye")

        listLuotBauChon.add("21.5k lượt bầu chọn")
        listLuotBauChon.add("18.5k lượt bầu chọn")
        listLuotBauChon.add("15k lượt bầu chọn")
        listLuotBauChon.add("8.8k lượt bầu chọn")

        binding.recyclerView.apply {
            val itemDecoration =
                DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
            itemDecoration.setDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.divider_rcv
                )!!
            )
            this.addItemDecoration(itemDecoration)
            this.layoutManager = LinearLayoutManager(context)
        }
        listRankAdapter = ListRankAdapter(listName, listLuotBauChon)
        binding.recyclerView.adapter = listRankAdapter
    }
}