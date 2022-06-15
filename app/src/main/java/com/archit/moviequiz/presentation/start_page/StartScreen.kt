package com.archit.moviequiz.presentation.start_page

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.archit.moviequiz.presentation.destinations.QuizPageScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun StartScreen(
    navigator: DestinationsNavigator,
) {
    Column() {
        TopAppBar() {
            Text(
                text = "Movie Quiz",
            )
        }
        Row(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Rule:")
            Text(text = "Every Question Consist of 3 Marks and Every Hint Reduces -1 Marks")
        }
        OutlinedButton(
            onClick = { navigator.navigate(QuizPageScreenDestination()) },
            modifier = androidx.compose.ui.Modifier.size(60.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.White)
        ) {
            Text(text = "Start")
        }
    }
}
