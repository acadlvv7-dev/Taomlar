package com.asadbek.taomlar.domain.usecase

import com.asadbek.taomlar.domain.model.Taom
import com.asadbek.taomlar.domain.repository.TaomRepository
import javax.inject.Inject

class GetTaomByCategoryUseCase @Inject constructor(
    private val repository: TaomRepository
) {

    suspend operator fun invoke(category: String):List<Taom>{
        return repository.getTaomByCategory(category)
    }
}