package com.asadbek.taomlar.domain.usecase

import com.asadbek.taomlar.domain.model.TaomDetail
import com.asadbek.taomlar.domain.repository.TaomRepository
import javax.inject.Inject

class GetTaomDetailUseCase @Inject constructor(private val repository: TaomRepository) {
    suspend operator fun invoke(id: String): TaomDetail {
        return repository.getTaomDetail(id) } }