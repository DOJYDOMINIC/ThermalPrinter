package com.example.myapplication.routs

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.viewmodels.ViewModelHolder
import com.example.myapplication.screens.CounterScreen
import com.example.myapplication.screens.LazyColumnScreen
import com.example.myapplication.screens.PrintReceiptButton

@Composable
fun AppNavHost(viewModelHolder: ViewModelHolder) {
    val navController = rememberNavController()
    val width = LocalConfiguration.current.screenWidthDp
    val height = LocalConfiguration.current.screenHeightDp
    val routeCounter = "counter"
    val routePrint= "printer"
    val routeLazyColumn = "lazyColumn"

    NavHost(navController = navController, startDestination = routeCounter) {
        composable(routeCounter) {
            CounterScreen(navController = navController, viewModel = viewModelHolder.viewModel1)
        }
        composable(routePrint) {
            PrintReceiptButton()
        }
        composable(routeLazyColumn) {
            LazyColumnScreen(navController = navController, viewModel = viewModelHolder.viewModel1)
        }

    }
}
