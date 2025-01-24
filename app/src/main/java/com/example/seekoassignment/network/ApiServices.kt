package com.example.seekoassignment.network

import com.example.seekhoassignment.data.model.top_anime_response.TopAnimeResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices{

    @GET("top/anime")
    fun getTopAnime(): Response<TopAnimeResponseDTO>

}