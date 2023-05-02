package com.example.start30s.fragment_tiktok

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.start30s.R
import com.example.start30s.databinding.FragmentOneClipBinding

class OneClipFragment : Fragment() {
    private lateinit var binding: FragmentOneClipBinding
    private lateinit var nameOne: String
    private lateinit var nameTeam: String
    private lateinit var viewPager: VerticalViewPager
    private lateinit var viewAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one_clip, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameOne = arguments?.getString("nameOne").toString()
        nameTeam = arguments?.getString("nameTeam").toString()

        viewPager = view.findViewById(R.id.viewPager) as VerticalViewPager
        viewAdapter = ViewPagerAdapter(parentFragmentManager, context!!, nameOne, nameTeam)
        viewPager.adapter = viewAdapter
    }
}