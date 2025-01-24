package com.example.seekoassignment.mainflow.home.animeList.util.usecases

import com.example.seekoassignment.network.data.top_anime_response.TopAnimeResponseDTO
import com.example.seekoassignment.mainflow.home.animeList.util.reposiotry.AnimeRepositoryImpl
import com.example.seekoassignment.network.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopAnimeUseCase @Inject constructor(private val repository: AnimeRepositoryImpl) {

    suspend operator fun invoke(): Flow<ApiResult<TopAnimeResponseDTO>> {
        return repository.getTopAnime()
    }
}