package edu.unikom.parsingapipubliksuperheroquiz2.data.network

import edu.unikom.parsingapipubliksuperheroquiz2.data.model.SuperheroResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all.json")
    fun getAllHeroes(): Call<List<SuperheroResponse>>
}