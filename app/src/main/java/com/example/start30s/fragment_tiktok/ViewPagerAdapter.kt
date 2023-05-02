package com.example.start30s.fragment_tiktok

import android.content.Context
import androidx.fragment.app.FragmentStatePagerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.start30s.R
import java.util.ArrayList

class ViewPagerAdapter(
    fm: FragmentManager,
    private val context: Context,
    nameOne: String,
    nameTeam: String
) : FragmentStatePagerAdapter(fm) {
    private val nameOne: String = nameOne
    private val nameTeam: String = nameTeam
    private val listMp4 = ArrayList<String>()
    override fun getItem(position: Int): Fragment {
        listMp4.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4")
        listMp4.add(context.getString(R.string.exo_url))
        listMp4.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4")
        listMp4.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4")
        listMp4.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4")
        listMp4.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4")
        listMp4.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4")
        listMp4.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4")
        listMp4.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4")
        val child = ChildFragment()
        val bundle = Bundle()
        bundle.putString("mp4", listMp4[position])
        bundle.putString("nameOne", nameOne)
        bundle.putString("nameTeam", nameTeam)
        child.arguments = bundle
        return child
    }

    override fun getCount(): Int {
        return 9
    }
}