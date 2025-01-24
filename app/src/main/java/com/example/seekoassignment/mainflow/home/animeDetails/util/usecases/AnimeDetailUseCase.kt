package com.example.seekoassignment.mainflow.home.animeDetails.util.usecases

import com.example.seekhoassignment.data.model.anime_detail_response.AnimeDetailResponseDTO
import com.example.seekoassignment.mainflow.home.animeDetails.util.repository.AnimeDetailRepositoryImpl
import com.example.seekoassignment.network.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAnimeDetailsUseCase @Inject constructor(private val repository: AnimeDetailRepositoryImpl) {

    suspend operator fun invoke(animeId: Int): Flow<ApiResult<AnimeDetailResponseDTO>> {
        return repository.getAnimeDetails(animeId)
    }
}
