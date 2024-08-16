package com.zalo.safaricomtask.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val updateSavingsUseCase: UpdateSavingsUseCase
) : ViewModel() {

    var state by mutableStateOf(SavingsViewState())
        private set

    fun onAction(savingsViewAction: SavingsViewAction) {
        when (savingsViewAction) {
            SavingsViewAction.GetAllSavings -> {
                viewModelScope.launch {
                    getAllSavingsUseCase.execute().collect { allSavings ->
                        state = state.copy(savings = allSavings)
                    }
                }
            }

            is SavingsViewAction.InsertSavings -> {
                viewModelScope.launch {
                    insertSavingsUseCase.execute(savingsViewAction.savingsEntity)
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
