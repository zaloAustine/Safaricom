package com.zalo.safaricomtask.data.repository

import com.zalo.safaricomtask.data.model.SavingsEntity
import kotlinx.coroutines.flow.Flow

interface SavingsRepository {
    fun getAllSavings(): Flow<List<SavingsEntity>>
    suspend fun insertSavings(savingsEntity: SavingsEntity)
    suspend fun updateSavings(savingsEntity: SavingsEntity)
}