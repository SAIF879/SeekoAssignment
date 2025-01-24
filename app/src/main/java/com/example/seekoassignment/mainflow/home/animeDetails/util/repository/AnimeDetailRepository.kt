package com.example.seekoassignment.mainflow.home.animeDetails.util.repository

import com.example.seekhoassignment.data.model.anime_detail_response.AnimeDetailResponseDTO
import com.example.seekoassignment.network.ApiResult
import kotlinx.coroutines.flow.Flow

interface AnimeDetailRepository {
    suspend fun getAnimeDetails(animeId: Int): Flow<ApiResult<AnimeDetailResponseDTO>>
}
