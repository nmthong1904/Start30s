package com.example.start30s.fragment

import com.example.start30s.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.start30s.adapter.ListTeamDetailAdapter
import com.example.start30s.databinding.FragmentTeamDetailBinding


class TeamDetailFragment : Fragment() {
    private lateinit var binding: FragmentTeamDetailBinding
    private lateinit var nameTeam: String
    private lateinit var listNameTeamDetail: ArrayList<String>
    private lateinit var listImagesDetail: ArrayList<Int>
    private lateinit var teamDetailAdapter: ListTeamDetailAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_team_detail, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTeam = arguments?.getString("nameOneTeam").toString()
        binding.tvTeam.text = nameTeam
        binding.tvClipTeam.text = nameTeam

        listNameTeamDetail = ArrayList()
        listImagesDetail = ArrayList()

        listNameTeamDetail.add("Team Park Min Young")
        listNameTeamDetail.add("Team Ha Ji Won")
        listNameTeamDetail.add("Team Song Hye Kyo")
        listNameTeamDetail.add("Team Park Shin Hye")
        listNameTeamDetail.add("Team Kim So Hyun")
        listNameTeamDetail.add("Team Seo Ye Ji")
        listNameTeamDetail.add("Team Lee Se Young")

        listImagesDetail.add(R.drawable.itemdetail1)
        listImagesDetail.add(R.drawable.itemdetail2)
        listImagesDetail.add(R.drawable.itemdetail3)
        listImagesDetail.add(R.drawable.itemdetail2)
        listImagesDetail.add(R.drawable.itemdetail1)
        listImagesDetail.add(R.drawable.itemdetail2)
        listImagesDetail.add(R.drawable.itemdetail3)

        binding.recyclerView.apply {
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        teamDetailAdapter = ListTeamDetailAdapter(listNameTeamDetail, listImagesDetail, context!!)
        binding.recyclerView.adapter = teamDetailAdapter

        binding.imgClose.setOnClickListener {
            findNavController().navigate(R.id.action_teamDetailFragment_to_teamFragment)
        }

        binding.btnXemNgay.setOnClickListener {
            val nameOneTeam: String = nameTeam
            val bundle = Bundle()
            bundle.putString("nameOneTeam", nameOneTeam)
            findNavController().navigate(R.id.action_teamDetailFragment_to_teamClipFragment, bundle)
        }
    }
}