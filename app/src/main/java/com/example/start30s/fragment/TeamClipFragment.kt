package com.example.start30s.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.start30s.R
import com.example.start30s.adapter.ListTeamClipAdapter
import com.example.start30s.databinding.FragmentTeamClipBinding

class TeamClipFragment : Fragment() {
    private lateinit var binding: FragmentTeamClipBinding
    private lateinit var teamClipAdapter: ListTeamClipAdapter
    private lateinit var nameTeam: String
    private var listNameTeamClip: ArrayList<String> = ArrayList()
    private var listName: ArrayList<String> = ArrayList()
    private var listHeart: ArrayList<String> = ArrayList()
    private var listImagesClip: ArrayList<Int> = ArrayList()
    private var listImagesAvatar: ArrayList<Int> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_team_clip, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTeam = arguments?.getString("nameOneTeam").toString()
        binding.tvNameTeam.text = nameTeam
        val name: String = "#" + nameTeam.replace(" ", "").lowercase().trim()
        val controller = findNavController()

        listNameTeamClip.add(name)
        listNameTeamClip.add(name)
        listNameTeamClip.add(name)
        listNameTeamClip.add(name)
        listNameTeamClip.add(name)
        listNameTeamClip.add(name)
        listNameTeamClip.add(name)

        listName.add("Kim Tae Hee")
        listName.add("Han Hyo Joo")
        listName.add("Kim Da Mi")
        listName.add("Lee Sung Kyung")
        listName.add("Shin Hye Sun")
        listName.add("Park Bo Young")
        listName.add("Jun Ji Hyun")

        listHeart.add("21,5k")
        listHeart.add("3,5k")
        listHeart.add("7.5k")
        listHeart.add("11,5k")
        listHeart.add("5,5k")
        listHeart.add("20,5k")
        listHeart.add("5,1k")

        listImagesClip.add(R.drawable.item1)
        listImagesClip.add(R.drawable.item2)
        listImagesClip.add(R.drawable.item3)
        listImagesClip.add(R.drawable.item4)
        listImagesClip.add(R.drawable.item1)
        listImagesClip.add(R.drawable.item2)
        listImagesClip.add(R.drawable.item3)

        listImagesAvatar.add(R.drawable.itemdetail1)
        listImagesAvatar.add(R.drawable.itemdetail2)
        listImagesAvatar.add(R.drawable.itemdetail3)
        listImagesAvatar.add(R.drawable.itemdetail1)
        listImagesAvatar.add(R.drawable.itemdetail2)
        listImagesAvatar.add(R.drawable.itemdetail3)
        listImagesAvatar.add(R.drawable.itemdetail1)

        binding.recyclerView.apply {
            this.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        }
        teamClipAdapter = ListTeamClipAdapter(listNameTeamClip, listImagesClip, listImagesAvatar, listName, listHeart, controller, nameTeam)
        binding.recyclerView.adapter = teamClipAdapter

        binding.layoutClose.setOnClickListener {
            val nameOneTeam: String = nameTeam
            val bundle = Bundle()
            bundle.putString("nameOneTeam", nameOneTeam)
            findNavController().navigate(R.id.action_teamClipFragment_to_teamDetailFragment, bundle)
        }
    }
}