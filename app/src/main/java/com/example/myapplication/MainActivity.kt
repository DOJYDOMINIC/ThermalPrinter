package com.example.myapplication

import CounterViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.myapplication.viewmodels.ViewModelHolder
import com.example.myapplication.routs.AppNavHost
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    private val viewModel1: CounterViewModel by viewModels()
    private val viewModelHolder: ViewModelHolder by lazy {
        ViewModelHolder(
            viewModel1 = viewModel1,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme(
                dynamicColor = true,
            ) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavHost(viewModelHolder = viewModelHolder)
                }
            }
        }
    }
}
