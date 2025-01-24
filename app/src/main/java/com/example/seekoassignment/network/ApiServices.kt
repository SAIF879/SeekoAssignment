package com.example.seekoassignment.network

import com.example.seekhoassignment.data.model.anime_detail_response.AnimeDetailResponseDTO
import com.example.seekoassignment.network.data.top_anime_response.TopAnimeResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices{

    @GET("v4/top/anime")
    suspend fun getTopAnime(): Response<TopAnimeResponseDTO>


    @GET("anime/{anime_id}")
    suspend fun getAnimeDetails(
        @Path("anime_id") animeId: Int
    ): Response<AnimeDetailResponseDTO>

}