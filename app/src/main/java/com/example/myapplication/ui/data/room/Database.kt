package com.example.myapplication.ui.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.ui.data.model.NoteData

@Database(entities = [NoteData::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract val noteDao: Dao

    companion object {
        val name = "notes_db"
    }

}