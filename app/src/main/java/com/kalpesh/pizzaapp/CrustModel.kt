package com.kalpesh.pizzaapp

data class CrustModel(
    val defaultSize: Int,
    val id: Int,
    val name: String,
    val sizes: List<SizeModel>
)