package com.zalo.safaricomtask.presentation


data class SavingsViewState(
    val isLoading: Boolean = false,
    val savings: List<Save> = emptyList(),
    val total:String = "0",
    val startingAmount:Int = 50
)

data class Save(
    val week :String,
    val savingAmount:String,
    val date:String,
    val total:String
)