package com.zalo.safaricomtask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "savings")
data class SavingsEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) val savingId: Int = 0,
    @ColumnInfo(name = "amount") val savingAmount: String,
    @ColumnInfo(name = "week") val savingWeek: String,
)