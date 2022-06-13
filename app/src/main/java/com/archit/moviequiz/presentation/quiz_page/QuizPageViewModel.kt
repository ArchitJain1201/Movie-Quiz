package com.archit.moviequiz.presentation.quiz_page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.archit.moviequiz.domain.repostiory.QuizRepository
import com.archit.moviequiz.util.UserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizPageViewModel @Inject constructor(
    private val savedStateHandle:SavedStateHandle,
    private val repository: QuizRepository,
): ViewModel(){

    var state by mutableStateOf(QuizPageState())

    lateinit var userManager: UserManager
    val readFromDataStore = userManager.readFromDataStore.asLiveData()
    fun saveToDataStore(score: Int) = viewModelScope.launch(Dispatchers.IO) {
        userManager.saveToDataStore(score)
    }

    init {
    }
}