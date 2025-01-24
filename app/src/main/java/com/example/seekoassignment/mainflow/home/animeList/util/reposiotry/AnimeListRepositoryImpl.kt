package com.example.seekoassignment.mainflow.home.animeList.util.reposiotry

import android.util.Log
import com.example.seekoassignment.network.data.top_anime_response.TopAnimeResponseDTO
import com.example.seekoassignment.network.ApiResult
import com.example.seekoassignment.network.ApiServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(private val animeService: ApiServices)
    : AnimeListRepository {

    override suspend fun getTopAnime(): Flow<ApiResult<TopAnimeResponseDTO>> = flow {
        emit(ApiResult.Loading)
        Log.d("AnimeRepository", "Fetching top anime started")
        try {
            val response = animeService.getTopAnime()
            Log.d("AnimeRepository", "Response received: $response")
            if (response.isSuccessful && response.body() != null) {
                Log.d("AnimeRepository", "Successful response: ${response.body()}")
                emit(ApiResult.Success(response.body()!!))
            } else {
                Log.e("AnimeRepository", "Error response: ${response.message()}")
                emit(ApiResult.Error("Error: ${response.message()}"))
            }
        } catch (e: Exception) {
            Log.e("AnimeRepository", "Exception occurred: ${e.localizedMessage}")
            emit(ApiResult.Error(e.localizedMessage ?: "Unknown Error"))
        }
    }
}