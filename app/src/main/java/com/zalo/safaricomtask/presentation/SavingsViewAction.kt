package com.zalo.safaricomtask.presentation

import com.zalo.safaricomtask.data.model.SavingsEntity

sealed class SavingsViewAction {
    data class UpdateSavings(val savingsEntity: SavingsEntity) : SavingsViewAction()
    data class InsertSavings(val initialValue:Int) : SavingsViewAction()
    data class GetAllSavings(val initialValue:Int) : SavingsViewAction()
}