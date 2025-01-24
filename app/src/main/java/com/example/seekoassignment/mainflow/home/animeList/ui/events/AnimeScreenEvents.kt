package com.example.seekoassignment.mainflow.home.animeList.ui.events

sealed class AnimeScreenEvents {
    data class OnNavigate(val id: Int?) : AnimeScreenEvents()
}
