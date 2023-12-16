package com.example.myapplication.ui.presentation.ui.home

import com.example.myapplication.ui.data.model.NoteData

sealed class NoteEvent {

    data class Insert(val noteData: NoteData) : NoteEvent()

    data class Delete(val noteData: NoteData) : NoteEvent()

}