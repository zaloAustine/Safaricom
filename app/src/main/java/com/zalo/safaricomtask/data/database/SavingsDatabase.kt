package com.zalo.safaricomtask.data.database

import SavingsDao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.zalo.safaricomtask.data.model.SavingsEntity

@Database(
    version = 1,
    entities = [SavingsEntity::class],
    exportSchema = false
)
abstract class SavingsDatabase : RoomDatabase() {
    abstract fun savingsDao(): SavingsDao
}
