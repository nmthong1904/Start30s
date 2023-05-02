package com.example.start30s.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

@Entity(tableName = "chatChatChat")
public class ChatObject {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nameChat;
    private String chatChat;

    public ChatObject(String nameChat, String chatChat) {
        this.nameChat = nameChat;
        this.chatChat = chatChat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameChat() {
        return nameChat;
    }

    public void setNameChat(String nameChat) {
        this.nameChat = nameChat;
    }

    public String getChatChat() {
        return chatChat;
    }

    public void setChatChat(String chatChat) {
        this.chatChat = chatChat;
    }


}
