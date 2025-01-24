package com.example.seekoassignment.mainflow.home.animeList.util.usecases

import com.example.seekhoassignment.data.model.top_anime_response.TopAnimeResponseDTO
import com.example.seekoassignment.mainflow.home.animeList.util.reposiotry.AnimeRepositoryImpl
import com.example.seekoassignment.network.ApiResult
import kotlinx.coroutines.flow.Flow

class GetTopAnimeUseCase(private val repository: AnimeRepositoryImpl) {

    suspend operator fun invoke(): Flow<ApiResult<TopAnimeResponseDTO>> {
        return repository.getTopAnime()
    }
}