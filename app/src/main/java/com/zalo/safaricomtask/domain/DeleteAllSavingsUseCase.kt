package com.zalo.safaricomtask.domain

import com.zalo.safaricomtask.data.repository.SavingsRepository
import javax.inject.Inject

class DeleteAllSavingsUseCase @Inject constructor(private val savingsRepository: SavingsRepository)  {
    suspend fun execute() = savingsRepository.deleteAllSavings()
}