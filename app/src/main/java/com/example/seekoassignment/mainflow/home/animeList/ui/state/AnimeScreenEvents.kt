package com.example.seekoassignment.mainflow.home.animeList.ui.state

sealed class AnimeScreenEvents {
    data class OnNavigate(val id: Int?) : AnimeScreenEvents()
}
