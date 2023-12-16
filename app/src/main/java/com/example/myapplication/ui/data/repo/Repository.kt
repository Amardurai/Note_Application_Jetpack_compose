package com.example.myapplication.ui.data.repo

import com.example.myapplication.ui.data.model.NoteData
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun insertNote(noteData: NoteData)
    fun getNote() : Flow<List<NoteData>>
    suspend fun deleteNote(noteData: NoteData)
}