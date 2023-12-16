package com.example.myapplication.ui.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.data.model.NoteData
import com.example.myapplication.ui.data.repo.RepositoryImp
import com.example.myapplication.ui.data.room.Dao
import com.example.myapplication.ui.data.room.Database
import com.example.myapplication.ui.presentation.ui.MainActivity.MainViewModel
import com.example.myapplication.ui.presentation.utils.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onEvent: (NoteEvent) -> Unit
) {
    val notes by viewModel.notesList
    var count by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "Note Application") }
            )
        }
    ) {
        Surface(
            Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.Green)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Column {
                    Button(onClick = {
                        count++
                        val data = NoteData(
                            id = count,
                            title = "Amar$count",
                            desc = "Am Native android developer working in walmart product based company$count"
                        )
                        onEvent(NoteEvent.Insert(data))
                    }) {
                        Text(text = "Insert")
                    }
                    LazyColumn {
                        items(notes ?: emptyList()) {
                            Column {
                                Text(text = "TiTle ${it.title}")
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(text = "Description ${it.desc}")
                            }
                        }
                    }

                }


            }
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen {

    }
}