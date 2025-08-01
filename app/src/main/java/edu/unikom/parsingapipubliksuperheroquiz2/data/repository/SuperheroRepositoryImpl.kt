package edu.unikom.parsingapipubliksuperheroquiz2.data.repository

import edu.unikom.parsingapipubliksuperheroquiz2.data.model.SuperheroResponse
import edu.unikom.parsingapipubliksuperheroquiz2.domain.repository.SuperheroRepository
import edu.unikom.parsingapipubliksuperheroquiz2.data.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuperheroRepositoryImpl : SuperheroRepository {
    override fun getAllHeroes(callback: (List<SuperheroResponse>?, Throwable?) -> Unit) {
        ApiConfig.getApiService().getAllHeroes().enqueue(object : Callback<List<SuperheroResponse>> {
            override fun onResponse(
                call: Call<List<SuperheroResponse>>,
                response: Response<List<SuperheroResponse>>
            ) {
                if (response.isSuccessful) {
                    callback(response.body(), null)
                } else {
                    callback(null, Throwable("Unsuccessful response"))
                }
            }

            override fun onFailure(call: Call<List<SuperheroResponse>>, t: Throwable) {
                callback(null, t)
            }
        })
    }
}