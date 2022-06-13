package com.archit.moviequiz.presentation.quiz_page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.archit.moviequiz.domain.repostiory.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizPageViewModel @Inject constructor(
    private val savedStateHandle:SavedStateHandle,
    private val repository: QuizRepository,
): ViewModel(){
    var state by mutableStateOf(QuizPageState())
    init {
    }
}