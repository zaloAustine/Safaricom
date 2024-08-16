package com.zalo.safaricomtask.domain

import com.zalo.safaricomtask.data.model.SavingsEntity
import com.zalo.safaricomtask.data.repository.SavingsRepository
import javax.inject.Inject

class UpdateSavingsUseCase @Inject constructor(private val savingsRepository: SavingsRepository) {
    suspend fun execute(savingsEntity: SavingsEntity) {
        savingsRepository.updateSavings(savingsEntity)
    }
}
