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
import com.example.start30s.adapter.ListTeamAdapter
import com.example.start30s.databinding.FragmentTeamBinding

class TeamFragment : Fragment() {
    private lateinit var binding: FragmentTeamBinding
    private lateinit var listNameTeam: ArrayList<String>
    private lateinit var listImages: ArrayList<Int>
    private lateinit var listTeamAdapter: ListTeamAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_team, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        listNameTeam = ArrayList()
        listImages = ArrayList()

        listNameTeam.add("Team Park Min Young")
        listNameTeam.add("Team Ha Ji Won")
        listNameTeam.add("Team Song Hye Kyo")
        listNameTeam.add("Team Park Shin Hye")
        listNameTeam.add("Team Kim So Hyun")
        listNameTeam.add("Team Seo Ye Ji")
        listNameTeam.add("Team Lee Se Young")

        listImages.add(R.drawable.item1)
        listImages.add(R.drawable.item2)
        listImages.add(R.drawable.item3)
        listImages.add(R.drawable.item4)
        listImages.add(R.drawable.item1)
        listImages.add(R.drawable.item2)
        listImages.add(R.drawable.item3)

        binding.recyclerView.apply {
            this.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        }
        listTeamAdapter = ListTeamAdapter(listNameTeam, listImages, context!!, controller)
        binding.recyclerView.adapter = listTeamAdapter
    }
}