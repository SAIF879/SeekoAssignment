package com.example.seekoassignment.mainflow.home.animeList.util.reposiotry

import com.example.seekhoassignment.data.model.top_anime_response.TopAnimeResponseDTO
import com.example.seekoassignment.network.ApiResult
import com.example.seekoassignment.network.ApiServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AnimeRepositoryImpl(private val animeService: ApiServices) : AnimeListRepository {

    override suspend fun getTopAnime(): Flow<ApiResult<TopAnimeResponseDTO>> = flow {
        emit(ApiResult.Loading)
        try {
            val response = animeService.getTopAnime()
            if (response.isSuccessful && response.body() != null) {
                emit(ApiResult.Success(response.body()))
            } else {
                emit(ApiResult.Error("Error: ${response.message()}"))
            }
        } catch (e: Exception) {
            emit(ApiResult.Error(e.localizedMessage ?: "Unknown Error"))
        }
    }
}
