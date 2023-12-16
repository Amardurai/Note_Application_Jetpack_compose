package com.example.myapplication.ui.presentation.ui.MainActivity

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.ui.data.model.NoteData
import com.example.myapplication.ui.data.repo.RepositoryImp
import com.example.myapplication.ui.presentation.ui.home.NoteEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(val repositoryImp: RepositoryImp) : ViewModel() {

    private val _notesList = mutableStateOf<List<NoteData>?>(null)
    val notesList: State<List<NoteData>?> get() = _notesList

    init {
        repositoryImp.getNote().onEach {
            _notesList.value = it
        }.launchIn(viewModelScope)

    }

    fun onEvent(noteEvent: NoteEvent) {
        when (noteEvent) {
            is NoteEvent.Delete -> TODO()
            is NoteEvent.Insert -> {
                viewModelScope.launch {
                    repositoryImp.insertNote(noteEvent.noteData)
                }
            }
        }
    }
}