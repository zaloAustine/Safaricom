package com.zalo.safaricomtask.presentation

import com.zalo.safaricomtask.data.model.SavingsEntity

data class SavingsViewState(
    val isLoading: Boolean = false,
    val savings: List<SavingsEntity> = emptyList(),
)