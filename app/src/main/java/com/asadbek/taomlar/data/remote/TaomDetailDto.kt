package com.asadbek.taomlar.data.remote

import com.google.gson.annotations.SerializedName

data class TaomDetailResponseDto(
    @SerializedName("meals") val meals: List<TaomDetailDto>?)

data class TaomDetailDto(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strMealThumb") val imageUrl: String,
    @SerializedName("strInstructions") val instructions: String
)