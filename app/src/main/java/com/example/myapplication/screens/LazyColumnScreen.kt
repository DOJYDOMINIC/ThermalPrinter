package com.example.myapplication.screens

import CounterViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LazyColumnScreen(navController: NavHostController, viewModel: CounterViewModel) {
    val items = viewModel.items.collectAsState()
    val loading = viewModel.loading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchItemsFromApi() // Fetch items from the API
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Button(onClick = { navController.popBackStack() }) {
                    Text(text = "Back")
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Search Field

            // Loading Indicator or Content
            if (loading.value) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Loading...")
                }
            } else {
                // LazyVerticalGrid
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(150.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(items.value) { item ->
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                                .background(Color.Gray)
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Name: ${item.name}",
                                modifier = Modifier.padding(bottom = 4.dp),
                                color = Color.White
                            )
                            Text(
                                text = "Price: ${item.data?.price ?: "N/A"}",
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}



