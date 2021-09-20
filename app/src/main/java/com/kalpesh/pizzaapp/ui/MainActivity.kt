package com.kalpesh.pizzaapp.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kalpesh.pizzaapp.Model.ResponseModel
import com.kalpesh.pizzaapp.R
import com.kalpesh.pizzaapp.api.ApiClient
import com.kalpesh.pizzaapp.api.Network
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var name: Int = 0
    var size: Int = 0
    var qty: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            name = etPizzaName.text.toString().toInt()
            size = etPizzaSize.text.toString().toInt()
            qty = etQuantity.text.toString().toInt()
            apiCall()
        }


    }


    private fun apiCall() {
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        val call = apiClient.getPizza()
        call.enqueue(object : Callback<ResponseModel> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<ResponseModel>,
                response: retrofit2.Response<ResponseModel>
            ) {
                //  buildData(response)

                if (response.body() != null) {
                    var totalPrice = qty * response.body()!!.crusts[name].sizes[size].price
                    tvPizzaName.text = response.body()!!.crusts[name].name
                    tvPizzaPrice.text = "Rs$totalPrice"
                    tvPizzaSize.text = response.body()!!.crusts[name].sizes[size].name
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun buildData(responseModel: Response<ResponseModel>) {

    }
}