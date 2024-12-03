package com.example.actividad4.models

import com.google.gson.annotations.SerializedName

data class Paises(
    @SerializedName("name") val nombre: Name,
    @SerializedName("flag") val bandera: String
)

data class Name(
    @SerializedName("common") val common: String
)
