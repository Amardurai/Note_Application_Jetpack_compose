package com.example.myapplication.ui.data.repo

import com.example.myapplication.ui.data.model.NoteData
import com.example.myapplication.ui.data.room.Dao
import com.example.myapplication.ui.data.room.Database
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImp @Inject constructor(val dataBase: Database) : Repository {
    override suspend fun insertNote(noteData: NoteData) {
        dataBase.noteDao.insert(noteData)
    }

    override fun getNote(): Flow<List<NoteData>> {
        return dataBase.noteDao.getNote()
    }

    override suspend fun deleteNote(noteData: NoteData) {
        dataBase.noteDao.deleteNote(noteData)
    }
}