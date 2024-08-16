package com.zalo.safaricomtask.data.di

import android.content.Context
import androidx.room.Room
import com.zalo.safaricomtask.data.database.SavingsDao
import com.zalo.safaricomtask.data.database.SavingsDatabase
import com.zalo.safaricomtask.data.repository.SavingsRepository
import com.zalo.safaricomtask.data.repository.SavingsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideSavingsDatabase(
        @ApplicationContext context: Context
    ): SavingsDatabase = Room.databaseBuilder(
        context = context,
        name = "savings",
        klass = SavingsDatabase::class.java
    ).fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideSavingsDao(
        savingsDatabase: SavingsDatabase
    ): SavingsDao = savingsDatabase.savingsDao()

    @Provides
    @Singleton
    fun provideSavingsRepository(savingsDao: SavingsDao): SavingsRepository = SavingsRepositoryImpl(savingsDao)
}