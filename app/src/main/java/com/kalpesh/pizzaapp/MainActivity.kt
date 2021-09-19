package com.kalpesh.pizzaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiCall()

    }

    private fun apiCall() {
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        val call = apiClient.getPizza()
        call.enqueue(object : Callback<ResponseModel> {
            override fun onResponse(
                call: Call<ResponseModel>,
                response: retrofit2.Response<ResponseModel>
            ) {
                buildData(response)
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun buildData(responseModel: Response<ResponseModel>) {

    }
}