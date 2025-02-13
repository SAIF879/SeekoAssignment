package com.example.seekoassignment.mainflow.home.animeDetails.util.repository

import com.example.seekhoassignment.data.model.anime_detail_response.AnimeDetailResponseDTO
import com.example.seekoassignment.network.ApiResult
import com.example.seekoassignment.network.ApiServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AnimeDetailRepositoryImpl @Inject constructor(private val animeService: ApiServices) : AnimeDetailRepository {

    override suspend fun getAnimeDetails(animeId: Int): Flow<ApiResult<AnimeDetailResponseDTO>> = flow {
        emit(ApiResult.Loading)

        val response = animeService.getAnimeDetails(animeId)

        if (response.isSuccessful && response.body() != null) {
            emit(ApiResult.Success(response.body()!!))
        } else {
            emit(ApiResult.Error("Error: ${response.message()}"))
        }
    }
}

