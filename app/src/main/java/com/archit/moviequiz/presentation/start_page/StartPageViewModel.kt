package com.archit.moviequiz.presentation.start_page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartPageViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(StartPageState())
    init {

    }
    private fun starting(){
        viewModelScope.launch{
        }
    }
}