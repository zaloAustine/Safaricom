package com.zalo.safaricomtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.ExperimentalSafeArgsApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zalo.safaricomtask.presentation.HomeScreen
import com.zalo.safaricomtask.presentation.SavingsViewState
import com.zalo.safaricomtask.presentation.SavingsViewmodel
import com.zalo.safaricomtask.ui.theme.SafaricomTaskTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@OptIn(ExperimentalSafeArgsApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            SafaricomTaskTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Home) {
                    composable<Home> {
                        val savingsViewmodel: SavingsViewmodel = hiltViewModel()
                        HomeScreen(savingsViewmodel.state, savingsViewmodel::onAction)
                    }
                }
            }
        }
    }
}

@Serializable
object Home

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SafaricomTaskTheme {
        HomeScreen(savingsViewState = SavingsViewState(), onAction = {})
    }
}