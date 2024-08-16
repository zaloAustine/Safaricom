package com.zalo.safaricomtask.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zalo.safaricomtask.data.model.SavingsEntity
import com.zalo.safaricomtask.domain.DeleteAllSavingsUseCase
import com.zalo.safaricomtask.domain.GetAllSavingsUseCase
import com.zalo.safaricomtask.domain.InsertSavingsUseCase
import com.zalo.safaricomtask.domain.UpdateSavingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavingsViewmodel @Inject constructor(
    private val getAllSavingsUseCase: GetAllSavingsUseCase,
    private val insertSavingsUseCase: InsertSavingsUseCase,
    private val updateSavingsUseCase: UpdateSavingsUseCase,
    private val deleteAllSavingsUseCase: DeleteAllSavingsUseCase
) : ViewModel() {

    var state by mutableStateOf(SavingsViewState())
        private set

    fun onAction(savingsViewAction: SavingsViewAction) {
        when (savingsViewAction) {
            is SavingsViewAction.GetAllSavings -> {
                viewModelScope.launch {
                    getAllSavingsUseCase.execute().collect { allSavings ->

                        val startingAmount = savingsViewAction.initialValue
                        var runningTotal = 0

                        val savings = allSavings.map { saving ->

                            val amount = startingAmount * saving.savingWeek.toInt()
                            runningTotal += amount

                            Save(
                                week = saving.savingWeek,
                                savingAmount = saving.savingAmount,
                                date = "",
                                total = runningTotal.toString()
                            )
                        }
                        state = state.copy(savings = savings)
                    }
                }
            }

            is SavingsViewAction.InsertSavings -> {
                viewModelScope.launch {
                    deleteAllSavingsUseCase.execute()
                    (1..52).map { week ->
                        insertSavingsUseCase.execute(
                            SavingsEntity(
                                savingWeek = week.toString(),
                                savingAmount = (savingsViewAction.initialValue * week).toString()
                            )
                        )
                    }
                }
            }

            is SavingsViewAction.UpdateSavings -> {
                viewModelScope.launch {
                    updateSavingsUseCase.execute(savingsViewAction.savingsEntity)
                }
            }
        }
    }
}
