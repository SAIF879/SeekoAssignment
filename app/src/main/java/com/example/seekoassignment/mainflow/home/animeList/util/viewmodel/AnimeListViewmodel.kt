package com.example.seekoassignment.mainflow.home.animeList.util.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekoassignment.network.data.top_anime_response.TopAnimeResponseDTO
import com.example.seekoassignment.mainflow.home.animeList.util.usecases.GetTopAnimeUseCase
import com.example.seekoassignment.network.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeListViewModel @Inject constructor(private val getTopAnimeUseCase: GetTopAnimeUseCase) : ViewModel() {

    init {
        fetchTopAnime()
    }

    private val _topAnimeState = MutableStateFlow<ApiResult<TopAnimeResponseDTO>>(ApiResult.Loading)
    val topAnimeState: StateFlow<ApiResult<TopAnimeResponseDTO>> = _topAnimeState

   private fun fetchTopAnime() {
        viewModelScope.launch(Dispatchers.IO) {
            getTopAnimeUseCase().collect { result ->
                _topAnimeState.value = result
            }
        }
    }
}