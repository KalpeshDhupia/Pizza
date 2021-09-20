package com.kalpesh.pizzaapp.Model

data class CrustModel(
    val defaultSize: Int,
    val id: Int,
    val name: String,
    val sizes: List<SizeModel>
)