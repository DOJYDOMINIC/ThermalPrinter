package com.example.myapplication.screens

import CounterViewModel
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dantsu.escposprinter.EscPosPrinter
import com.dantsu.escposprinter.connection.bluetooth.BluetoothConnection
import com.dantsu.escposprinter.connection.bluetooth.BluetoothPrintersConnections
import com.dantsu.escposprinter.textparser.PrinterTextParserImg


@Composable
fun CounterScreen(navController: NavHostController, viewModel: CounterViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.navigate("lazyColumn") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Go to LazyColumn")
        }
        Button(
            onClick = { viewModel.fetchItemsFromApi() },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Fetch API Data")
        }
        Button(
            onClick = { navController.navigate("printer") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Print")
        }

        Button(
            onClick = { viewModel.fetchItemsApi("7") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Fetch API")
        }
    }
}
