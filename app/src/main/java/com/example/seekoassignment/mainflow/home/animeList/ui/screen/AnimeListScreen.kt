package com.example.seekoassignment.mainflow.home.animeList.ui.screen

import android.annotation.SuppressLint
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.seekoassignment.mainflow.home.animeList.ui.components.AnimeItem
import com.example.seekoassignment.mainflow.home.animeList.ui.state.AnimeScreenEvents
import com.example.seekoassignment.navigation.HomeScreens
import com.example.seekoassignment.network.ApiResult
import com.example.seekoassignment.network.data.top_anime_response.TopAnimeResponseDTO

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeListScreen( list: ApiResult<TopAnimeResponseDTO> , animeScreenEvents: (AnimeScreenEvents)->Unit){

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Anime List") }
                )
            },
            content = { paddingValues ->
                when(list) {
                    is ApiResult.Loading -> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues), contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                    is ApiResult.Error -> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues), contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Error: ${list.message}")
                        }
                    }
                    is ApiResult.Success -> {
                        LazyColumn(modifier = Modifier.padding(paddingValues)) {
                            list.data?.let {
                                items(items = it.data) { anime ->
                                  AnimeItem(anime = anime) {
                                      animeScreenEvents.invoke(AnimeScreenEvents.OnNavigate(anime.malId))
                                  }
                                }
                            }
                        }
                    }
                }
            },
        )
    }



