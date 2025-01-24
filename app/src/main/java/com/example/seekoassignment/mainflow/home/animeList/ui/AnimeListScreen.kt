package com.example.seekoassignment.mainflow.home.animeList.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.seekoassignment.mainflow.home.animeList.util.viewmodel.AnimeListViewModel

@Composable
fun AnimeListScreen(viewmodel : AnimeListViewModel){
    val events by viewmodel.topAnimeState.collectAsState()
    Text(text = "asdasdasd")

}