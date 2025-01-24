package com.example.seekoassignment.di

import com.example.seekoassignment.network.ApiServices
import com.example.seekoassignment.network.OkHttpClientHelper
import com.example.seekoassignment.util.others.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun ProvidesAnimeApi(): ApiServices {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(OkHttpClientHelper().getOkHttpClient())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiServices::class.java)
    }
    }