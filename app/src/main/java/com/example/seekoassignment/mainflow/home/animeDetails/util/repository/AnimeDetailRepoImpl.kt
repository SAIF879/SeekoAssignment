package com.example.seekoassignment.mainflow.home.animeDetails.util.repository

import com.example.seekhoassignment.data.model.anime_detail_response.AnimeDetailResponseDTO
import com.example.seekoassignment.network.ApiResult
import com.example.seekoassignment.network.ApiServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

import android.util.Log

class AnimeDetailRepositoryImpl @Inject constructor(private val animeService: ApiServices) : AnimeDetailRepository {

    override suspend fun getAnimeDetails(animeId: Int): Flow<ApiResult<AnimeDetailResponseDTO>> = flow {
        emit(ApiResult.Loading)

        Log.d("AnimeDetailRepository", "Fetching anime details for animeId: $animeId")

        try {
            val response = animeService.getAnimeDetails(animeId)
            Log.d("AnimeDetailRepository", "API call response: $response")

            if (response.isSuccessful && response.body() != null) {
                Log.d("AnimeDetailRepository", "Successfully fetched anime details for animeId: $animeId")
                emit(ApiResult.Success(response.body()!!))
            } else {
                Log.e("AnimeDetailRepository", "Error response: ${response.message()} for animeId: $animeId")
                emit(ApiResult.Error("Error: ${response.message()}"))
            }
        } catch (e: Exception) {
            Log.e("AnimeDetailRepository", "Exception occurred while fetching anime details: ${e.localizedMessage}")
            emit(ApiResult.Error(e.localizedMessage ?: "Unknown Error"))
        }
    }
}
