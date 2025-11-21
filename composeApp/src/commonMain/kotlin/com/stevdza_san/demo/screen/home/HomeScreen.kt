package com.stevdza_san.demo.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel
import kotlin.random.Random

@Composable
fun HomeScreen(
    navigateToDetails: (Int) -> Unit,
) {
    val viewModel = koinViewModel<HomeViewModel>()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                navigateToDetails(Random.nextInt(from = 1, until = 100))
            }
        ) {
            Text(
                text = "Go to Details"
            )
        }
    }
}