package com.example.start30s.fragment

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.start30s.R
import com.example.start30s.databinding.FragmentLiveBinding
import com.example.start30s.fragmentrank.RankFragmentDialog
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.material.bottomsheet.BottomSheetBehavior

class LiveFragment : Fragment() {
    private lateinit var binding: FragmentLiveBinding
    private lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var mediaItem: MediaItem
    private lateinit var mp4: String
    private lateinit var bottomSheet: View
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
    private lateinit var closeBottomSheet: ImageView
    private lateinit var layoutBauChon: ConstraintLayout
    private lateinit var layoutDaBauChon: ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_live, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playVideoLive()
        initView(view)

        binding.imgBottomSheetDialog2.setOnClickListener {
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

        binding.imgOpenDialogRank.setOnClickListener {
            val rankFragmentDialog: RankFragmentDialog = RankFragmentDialog()
            rankFragmentDialog.show(fragmentManager!!, "dialog")
        }

//        binding.layoutTalkLive.setOnClickListener {
//            findNavController().navigate(R.id.action_talkLiveFragment_to_informationFragment)
//        }

//        binding.layoutInformation.setOnClickListener {
//            findNavController().navigate(R.id.action_informationFragment_to_talkLiveFragment)
//        }
    }

    private fun playVideoLive() {
        mp4 = getString(R.string.exo_url)
        simpleExoPlayer = SimpleExoPlayer.Builder(context!!).build()
        binding.exoplayerview.player = simpleExoPlayer
        mediaItem = MediaItem.fromUri(mp4)
        simpleExoPlayer.addMediaItem(mediaItem)
        simpleExoPlayer.prepare()
        simpleExoPlayer.repeatMode = SimpleExoPlayer.REPEAT_MODE_ONE
        simpleExoPlayer.playWhenReady = true
    }

    private fun initView(view: View) {
        bottomSheet = view.findViewById(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        closeBottomSheet = view.findViewById(R.id.img_close_bottom_sheet_dialog)
        layoutBauChon = view.findViewById(R.id.layoutBauChon)
        layoutDaBauChon = view.findViewById(R.id.layoutDaBauChon)
    }


}