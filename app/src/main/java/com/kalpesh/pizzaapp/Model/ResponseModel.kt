package com.kalpesh.pizzaapp.Model

import com.kalpesh.pizzaapp.Model.CrustModel

data class ResponseModel(
    val crusts: List<CrustModel>,
    val defaultCrust: Int,
    val description: String,
    val isVeg: Boolean,
    val name: String
)