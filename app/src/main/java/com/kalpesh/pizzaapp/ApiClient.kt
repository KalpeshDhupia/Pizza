package com.kalpesh.pizzaapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("pizzas")
    fun getPizza() : Call<ResponseModel>

}