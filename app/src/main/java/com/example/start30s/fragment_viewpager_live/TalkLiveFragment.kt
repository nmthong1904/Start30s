package com.example.start30s.fragment_viewpager_live

import android.app.Activity
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.start30s.R
import com.example.start30s.adapter.ListChatAdapter
import com.example.start30s.database.ChatDATABASE
import com.example.start30s.databinding.FragmentTalkLiveBinding
import com.example.start30s.model.ChatObject

class TalkLiveFragment : Fragment() {
    private lateinit var binding: FragmentTalkLiveBinding
    private lateinit var listChatAdapter: ListChatAdapter
    private lateinit var mListChat: MutableList<ChatObject>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_talk_live, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listChatAdapter = ListChatAdapter()
        mListChat = ArrayList()
        listChatAdapter.setData(mListChat)

        binding.recyclerView.apply {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = listChatAdapter
        }

        binding.imgSend.setOnClickListener {
            addChat()
        }

        mListChat = ChatDATABASE.getInstance(context).chatDAO().listChat
        listChatAdapter.setData(mListChat)

        binding.layoutInformation.setOnClickListener {
            findNavController().navigate(R.id.action_talkLiveFragment_to_informationFragment)
        }
    }

    private fun addChat() {
        val strName: String = "Lee Ji Soo"
        val strChat: String = binding.edtChat.text.toString().trim()

        if (TextUtils.isEmpty(strChat) || TextUtils.isEmpty(strName)) {
            return
        }

        val chatObject: ChatObject =
            ChatObject(strName, strChat)
        ChatDATABASE.getInstance(context).chatDAO().insertChat(chatObject)

        binding.edtChat.setText("")

        hideSoftKetBoard()
        mListChat = ChatDATABASE.getInstance(context).chatDAO().listChat
        listChatAdapter.setData(mListChat)

    }

    private fun hideSoftKetBoard() {
        try {
            val inputMethodManager: InputMethodManager =
                context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                activity?.currentFocus?.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        } catch (ex: NullPointerException) {
            ex.printStackTrace()
        }
    }
}