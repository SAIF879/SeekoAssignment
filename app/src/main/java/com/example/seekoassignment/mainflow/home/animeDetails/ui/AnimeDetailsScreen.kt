package com.example.seekoassignment.mainflow.home.animeDetails.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.seekoassignment.mainflow.home.animeDetails.ui.components.YouTubeVideoPlayer
import com.example.seekoassignment.mainflow.home.animeDetails.util.viewmodel.AnimeDetailsViewModel
import com.example.seekoassignment.mainflow.home.animeList.ui.components.AppNetworkImage
import com.example.seekoassignment.network.ApiResult

@Composable
fun AnimeDetailsScreen(viewModel: AnimeDetailsViewModel, animeId: Int){
    val events by viewModel.animeDetailsState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchAnimeDetails(animeId)
    }

    when(events){
        is ApiResult.Error -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp), contentAlignment = Alignment.Center
            ) {
                Text(text = "Error: ${events.message}")
            }
        }
        ApiResult.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
            
        }
        is ApiResult.Success -> {
            Scaffold(
                content = { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        if (events.data?.data?.trailer?.url != null) {
                            YouTubeVideoPlayer(
                                url = events.data?.data?.trailer?.url!!,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
                        } else {
                            AppNetworkImage(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),
                                model = events.data?.data?.images?.jpg?.largeImageUrl
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 10.dp),
                            verticalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            Text(
                                text = events.data?.data?.title ?: events.data?.data?.titleEnglish
                                ?: events.data?.data?.titleJapanese ?: "Null",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleLarge
                            )

                            Row {
                                Text(
                                    text = "Number of Episodes - ",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = events.data?.data?.episodes.toString(),
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }

                            Row {
                                Text(
                                    text = "Score - ",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Text(
                                    text = events.data?.data?.score.toString(),
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }

                            events.data?.data?.genres?.map { it.name ?: "Null" }
                                ?.let { genreList ->
                                    Row {
                                        Text(
                                            text = "Genres - ",
                                            fontWeight = FontWeight.Bold,
                                            style = MaterialTheme.typography.titleMedium
                                        )


                                        Text(
                                            text = genreList.joinToString(", "),
                                            style = MaterialTheme.typography.titleMedium
                                        )
                                    }
                                }

                            Text(
                                text = "Synopsis -",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(
                                text = events.data?.data?.synopsis ?: "Null",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                    }
                }
            )
        }

        }
    }

