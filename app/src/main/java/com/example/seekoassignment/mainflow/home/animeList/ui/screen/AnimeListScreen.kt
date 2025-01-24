package com.example.seekoassignment.mainflow.home.animeList.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.seekoassignment.mainflow.home.animeList.ui.components.AnimeItem
import com.example.seekoassignment.mainflow.home.animeList.util.viewmodel.AnimeListViewModel
import com.example.seekoassignment.network.ApiResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeListScreen(viewmodel : AnimeListViewModel){
    val events by viewmodel.topAnimeState.collectAsState()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Anime List") }
                )
            },
            content = { paddingValues ->  // Accept contentPadding here
                when(events) {
                    is ApiResult.Loading -> {
                        // Loading state
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues), contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()  // Show loading spinner
                        }
                    }
                    is ApiResult.Error -> {
                        // Error state
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues), contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Error: ${events.message}")  // Show error message
                        }
                    }
                    is ApiResult.Success -> {
                        // Success state
                        LazyColumn(modifier = Modifier.padding(paddingValues)) {
                            events.data?.let {
                                items(it.data) { anime ->
                                  AnimeItem(anime = anime) {
                                      
                                  }
                                }
                            }
                        }
                    }
                }
            },
        )
    }



