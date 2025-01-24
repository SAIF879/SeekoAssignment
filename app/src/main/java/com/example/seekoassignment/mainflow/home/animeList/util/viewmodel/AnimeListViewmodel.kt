package com.example.seekoassignment.mainflow.home.animeList.util.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekhoassignment.data.model.top_anime_response.TopAnimeResponseDTO
import com.example.seekoassignment.mainflow.home.animeList.util.usecases.GetTopAnimeUseCase
import com.example.seekoassignment.network.ApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AnimeViewModel(private val getTopAnimeUseCase: GetTopAnimeUseCase) : ViewModel() {

    private val _topAnimeState = MutableStateFlow<ApiResult<TopAnimeResponseDTO>>(ApiResult.Loading)
    val topAnimeState: StateFlow<ApiResult<TopAnimeResponseDTO>> = _topAnimeState

    fun fetchTopAnime() {
        viewModelScope.launch {
            getTopAnimeUseCase().collect { result ->
                _topAnimeState.value = result
            }
        }
    }
}