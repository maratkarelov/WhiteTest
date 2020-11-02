package com.example.white.network

import com.example.white.data.entities.MyCharacter
import io.reactivex.Single
import retrofit2.http.GET

interface ServerAPI {
    @GET("characters")
    fun readCharacters(
    ): Single<List<MyCharacter>>

}
