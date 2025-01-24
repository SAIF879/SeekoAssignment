package com.example.seekoassignment.network

import com.example.seekoassignment.network.data.top_anime_response.TopAnimeResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices{

    @GET("v4/top/anime")
    suspend fun getTopAnime(): Response<TopAnimeResponseDTO>

}