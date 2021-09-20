package com.kalpesh.pizzaapp.api

import com.kalpesh.pizzaapp.Model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("pizzas")
    fun getPizza() : Call<ResponseModel>

}