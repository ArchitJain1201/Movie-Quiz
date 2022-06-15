package com.archit.moviequiz.presentation.end_page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.archit.moviequiz.presentation.destinations.QuizPageScreenDestination
import com.archit.moviequiz.presentation.destinations.StartScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun EndPageScreen(
    navigator: DestinationsNavigator,
) {
    //TODO: Fetch Data from Preference Data
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Total Score: --/30")
        Button(onClick = { navigator.navigate(StartScreenDestination())}, colors = ButtonDefaults.textButtonColors(backgroundColor = Color.Blue)) {
            Text(text = "Move to Home Screen")
        }
    }
}