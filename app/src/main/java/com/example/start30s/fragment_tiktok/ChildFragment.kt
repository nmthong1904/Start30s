package com.example.start30s.fragment_tiktok

import android.widget.TextView
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.SimpleExoPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.start30s.R
import com.example.start30s.databinding.FragmentChildBinding
import com.example.start30s.databinding.FragmentOneClipBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.material.bottomsheet.BottomSheetBehavior

class ChildFragment : Fragment() {
    private lateinit var binding: FragmentChildBinding
    private lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var mediaItem: MediaItem
    private lateinit var mp4: String

    private lateinit var nameOne: String
    private lateinit var nameTeam: String
    private lateinit var bottomSheet: View
    private lateinit var closeBottomSheet: ImageView
    private lateinit var tvNameBottomSheet: TextView
    private lateinit var tvTeamBottomSheet: TextView
    private lateinit var layoutBauChon: ConstraintLayout
    private lateinit var layoutDaBauChon: ConstraintLayout
    private lateinit var layoutBauChonFrag: ConstraintLayout
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_child, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        mp4 = bundle!!.getString("mp4").toString()
        nameOne = bundle.getString("nameOne").toString()
        nameTeam = bundle.getString("nameTeam").toString()

        initView(view)
        playTikTok()

        binding.tvName.text = nameOne
        binding.tvTeam.text = "#" + nameTeam.replace(" ", "")


        layoutBauChonFrag.setOnClickListener {
            tvNameBottomSheet.text = nameOne
            tvTeamBottomSheet.text = "#" + nameTeam.replace(" ", "")
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        closeBottomSheet.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        layoutBauChon.setOnClickListener {
            layoutBauChon.visibility = View.GONE
            layoutDaBauChon.visibility = View.VISIBLE
        }

        layoutDaBauChon.setOnClickListener {
            layoutDaBauChon.visibility = View.GONE
            layoutBauChon.visibility = View.VISIBLE
        }

        binding.imgClose.setOnClickListener {
            val nameOneTeam: String = nameTeam
            val bundle = Bundle()
            bundle.putString("nameOneTeam", nameOneTeam)
            findNavController().navigate(R.id.action_oneClipFragment_to_teamClipFragment, bundle)
        }

        binding.layoutLive.setOnClickListener {
            findNavController().navigate(R.id.action_oneClipFragment_to_liveFragment)
        }
    }

    private fun initView(view: View) {
        bottomSheet = view.findViewById(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        closeBottomSheet = view.findViewById(R.id.img_close_bottom_sheet_dialog)
        tvNameBottomSheet = view.findViewById(R.id.tvName)
        tvTeamBottomSheet = view.findViewById(R.id.tvTeam)
        layoutBauChon = view.findViewById(R.id.layoutBauChon)
        layoutDaBauChon = view.findViewById(R.id.layoutDaBauChon)
        layoutBauChonFrag = view.findViewById(R.id.layoutBauChonFrag)
    }

    private fun playTikTok() {
        simpleExoPlayer = SimpleExoPlayer.Builder(context!!).build()
        binding.exoplayerview.player = simpleExoPlayer
        mediaItem = MediaItem.fromUri(mp4)
        simpleExoPlayer.addMediaItem(mediaItem)
        simpleExoPlayer.prepare()
        simpleExoPlayer.repeatMode = SimpleExoPlayer.REPEAT_MODE_ONE
        simpleExoPlayer.playWhenReady = true
    }
}