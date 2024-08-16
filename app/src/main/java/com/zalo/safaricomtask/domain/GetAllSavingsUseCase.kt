package com.zalo.safaricomtask.domain

import com.zalo.safaricomtask.data.repository.SavingsRepository
import javax.inject.Inject

class GetAllSavingsUseCase @Inject constructor(private val savingsRepository: SavingsRepository)  {
    fun execute() = savingsRepository.getAllSavings()
}