package com.kalpesh.pizzaapp

data class ResponseModel(
    val crusts: List<CrustModel>,
    val defaultCrust: Int,
    val description: String,
    val isVeg: Boolean,
    val name: String
)