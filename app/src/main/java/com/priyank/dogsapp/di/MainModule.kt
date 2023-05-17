package com.priyank.dogsapp.di

import android.app.Application
import androidx.room.Room
import com.priyank.dogsapp.data.local.DogDatabase
import com.priyank.dogsapp.data.remote.DogsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): DogsApi {
        return Retrofit.Builder().baseUrl("https://dog.ceo/api/").addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(
            DogsApi::class.java
        )
    }

    @Provides
    @Singleton
    fun provideDogsDatabase(app: Application): DogDatabase {
        return Room.databaseBuilder(
            app, DogDatabase::class.java, "dog_db"
        ).build()
    }
}
