package com.example.seekoassignment.mainflow.home.animeList.util.reposiotry

import com.example.seekoassignment.network.data.top_anime_response.TopAnimeResponseDTO
import com.example.seekoassignment.network.ApiResult
import kotlinx.coroutines.flow.Flow

interface AnimeListRepository{
    suspend fun getTopAnime(): Flow<ApiResult<TopAnimeResponseDTO>>
}
