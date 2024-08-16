package com.zalo.safaricomtask.data.repository

import SavingsDao
import com.zalo.safaricomtask.data.model.SavingsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SavingsRepositoryImpl @Inject constructor(private val savingsDao: SavingsDao):
    SavingsRepository {
    override fun getAllSavings(): Flow<List<SavingsEntity>> {
        return savingsDao.getAllCartItems()
    }

    override suspend fun insertSavings(savingsEntity: SavingsEntity) {
        savingsDao.insertCartItems(listOf(savingsEntity))
    }

    override suspend fun updateSavings(savingsEntity: SavingsEntity) {
       savingsDao.updateCartItem(savingsEntity)
    }

}