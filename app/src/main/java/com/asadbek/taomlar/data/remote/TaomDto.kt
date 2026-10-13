package com.asadbek.taomlar.data.remote

import com.google.gson.annotations.SerializedName

data class TaomDto (
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val taomlarUrl: String

)

data class TaomResponseDto(
    @SerializedName("meals") val taoms: List<TaomDto>?
)