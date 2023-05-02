package com.example.start30s.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.start30s.model.ChatObject;

import java.util.List;

@Dao
public interface ChatDAO {

    @Insert
    void insertChat(ChatObject chat);

    @Query("SELECT * FROM chatChatChat")
    List<ChatObject> getListChat();
}
