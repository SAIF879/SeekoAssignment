package com.example.seekoassignment.mainflow.home.animeDetails.util.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekhoassignment.data.model.anime_detail_response.AnimeDetailResponseDTO
import com.example.seekoassignment.mainflow.home.animeDetails.util.usecases.GetAnimeDetailsUseCase
import com.example.seekoassignment.network.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailsViewModel @Inject constructor(private val getAnimeDetailsUseCase: GetAnimeDetailsUseCase) : ViewModel() {

    init {
        fetchAnimeDetails(1)
    }

    private val _animeDetailsState = MutableStateFlow<ApiResult<AnimeDetailResponseDTO>>(ApiResult.Loading)
    val animeDetailsState: StateFlow<ApiResult<AnimeDetailResponseDTO>> = _animeDetailsState

   private fun fetchAnimeDetails(animeId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getAnimeDetailsUseCase(animeId).collect { result ->
                _animeDetailsState.value = result
            }
        }
    }
}
