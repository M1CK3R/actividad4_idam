package com.example.actividad4.interfaces

import com.example.actividad4.models.Paises
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v3.1/name/{name}")
    fun getCountriesByName(@Path("name") name: String): Call<List<Paises>>
}