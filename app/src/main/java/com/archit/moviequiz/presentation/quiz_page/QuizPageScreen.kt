package com.archit.moviequiz.presentation.quiz_page

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterialApi::class)
@Destination
@Composable
fun QuizPageScreen(
    navigator: DestinationsNavigator,
    viewModel: QuizPageViewModel = hiltViewModel(),
){
    val state = viewModel.state
    val question =state.movieList[1]
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Rounded.ArrowBack, contentDescription = "Back Arrow")
            }
            Text(text = "Score: --/30")
        }
    }
    Text(text = question.name)
    SimpleRadioButtonComponent(option = question.option1)
    SimpleRadioButtonComponent(option = question.option2)
    SimpleRadioButtonComponent(option = question.option3)
    SimpleRadioButtonComponent(option = question.option4)
    Text(text = "Hint: On every open hint 1 marks mill be deducted")
    ExpandableCard(title = "Actor" , description = question.actor)
    ExpandableCard(title = "Music By" , description = question.movieBy)
    ExpandableCard(title = "Image" , description = question.imgUrl)
    Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.textButtonColors(backgroundColor = Color.Blue)) {
        if(true) {
            Text(text = "Next")
        }else {
            Text(text = "Finish")
        }
    }
}

@Composable
fun SimpleRadioButtonComponent(option: String) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(option) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            RadioButton(
                selected = (option==selectedOption),
                onClick = {
                    onOptionSelected(option)
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = option)
        }
    }
}