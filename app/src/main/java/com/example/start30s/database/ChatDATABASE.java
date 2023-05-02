package com.example.start30s.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.start30s.model.ChatObject;

@Database(entities = {ChatObject.class}, version = 1)
public abstract class ChatDATABASE extends RoomDatabase {
    private static final String DATABASE_NAME = "chat.db";
    private static ChatDATABASE instance;

    public static synchronized ChatDATABASE getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ChatDATABASE.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract ChatDAO chatDAO();
}
