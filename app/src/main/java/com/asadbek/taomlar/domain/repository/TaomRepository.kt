package com.asadbek.taomlar.domain.repository

import com.asadbek.taomlar.domain.model.Taom
import com.asadbek.taomlar.domain.model.TaomDetail

interface TaomRepository {
    suspend fun getTaomByCategory(category: String): List<Taom>
    suspend fun getTaomDetail(id: String): TaomDetail
}