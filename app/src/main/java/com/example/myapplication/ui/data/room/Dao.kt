package com.example.myapplication.ui.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.ui.data.model.NoteData
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noteData: NoteData)

    @Query("SELECT * FROM NoteData")
    fun getNote(): Flow<List<NoteData>>

    @Delete
    suspend fun deleteNote(noteData: NoteData)
}