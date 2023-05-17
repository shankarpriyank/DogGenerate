package com.priyank.dogsapp.data.remote

import com.priyank.dogsapp.data.model.DogInfo
import retrofit2.http.GET

interface DogsApi {

    @GET("breeds/image/random")
    suspend fun getImages(): DogInfo
}
