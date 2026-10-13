package com.asadbek.taomlar.data.repository

import com.asadbek.taomlar.data.remote.TaomApiService
import com.asadbek.taomlar.domain.model.Taom
import com.asadbek.taomlar.domain.model.TaomDetail
import com.asadbek.taomlar.domain.repository.TaomRepository
import javax.inject.Inject

class TaomRepositoryImpl @Inject constructor(
    private val api: TaomApiService
) : TaomRepository{
    override suspend fun getTaomByCategory(category: String): List<Taom> {
        val response = api.getTaomByCategory(category)
        return response.taoms.orEmpty().map {dto ->
            Taom(id = dto.id, name = dto.name, taomlarUrl = dto.taomlarUrl) } }

    override suspend fun getTaomDetail(id: String): TaomDetail {
        val response = api.getTaomDetail(id)
        val dto = response.meals.orEmpty().first()
        return TaomDetail(id = dto.id, name = dto.name, imageUrl = dto.imageUrl, instructions = dto.instructions
        )
    }
}


