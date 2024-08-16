package com.zalo.safaricomtask.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    savingsViewState: SavingsViewState,
    onAction: (SavingsViewAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val initialSaving = remember { mutableIntStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        onAction.invoke(SavingsViewAction.InsertSavings(initialSaving.intValue))
    }

    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {

        Text(text = "Savings Calculator", modifier = Modifier.padding(bottom = 16.dp))
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = initialSaving.intValue.toString(),
            onValueChange = { newValue ->
                if(newValue.isNotBlank()) {
                    initialSaving.intValue = newValue.toInt()
                }
            },
        )

        Spacer(modifier = Modifier.height(16.dp))

        FilledTonalButton(onClick = {
            if (initialSaving.intValue == 0 ) {
                Toast.makeText(
                    context,
                    "Please add a value  greater or less than 50",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                onAction.invoke(
                    SavingsViewAction.InsertSavings(initialSaving.intValue)
                )
            }
        }, modifier = modifier.fillMaxWidth()) {
            Text("Add initial value of 50 ksh")
        }
        Spacer(modifier = Modifier.height(16.dp))

        val savings = savingsViewState.savings

        Text("Your Current savings")

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(savings) { saving ->
                SavingsItem(saving.week, saving.savingAmount,saving.total,saving.date)
            }
        }
    }
}

@Composable
fun SavingsItem(week: String, amount: String,total:String,date:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "Week $week: ", modifier = Modifier.weight(1f))
        Text(text = "Date. $date", modifier = Modifier.weight(1f))
        Text(text = "Amount. $amount", modifier = Modifier.weight(1f))
        Text(text = "Total. $total", modifier = Modifier.weight(1f))
    }
}
