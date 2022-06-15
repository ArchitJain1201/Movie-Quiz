package com.archit.moviequiz.presentation.quiz_page

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.observe
import com.archit.moviequiz.domain.repostiory.QuizRepository
import com.archit.moviequiz.util.Resource
import com.archit.moviequiz.util.UserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizPageViewModel @Inject constructor(
    private val repository: QuizRepository,
): ViewModel(){

    var state by mutableStateOf(QuizPageState())

    //For Preference DataStore
    lateinit var userManager: UserManager
    val readFromDataStore = userManager.readFromDataStore.asLiveData()//to display the score
    fun saveToDataStore(score: Int) = viewModelScope.launch(Dispatchers.IO) {
        userManager.saveToDataStore(score)
    }

    //for Score 1. read Score 2. Write score 2a. PreviousScore + penalty
    var score: Int = 0
    var Totalscore: Int = 0
//    private fun observeData(){
//        this.userManager.readFromDataStore.asLiveData().observe(this){
//            Totalscore = it
//        }
//    }
    //TODO: LiveData<Int> to Int
//    fun updateScore(option: String){
//        if(score==0){
//            println("no Change")
//        }else{
//            val storedScore: Int = readFromDataStore.value
//            val currentScore = storedScore+penalty+score
//            saveToDataStore(currentScore)
//        }
//
//    }

    //QuestionBank 1.FetchData 2.MapData( Includes Numbering )  3.Store the Clicked option
    //TODO: Temparary Paging is done as var should be done through DataStore
    //TODO: Have to Give option of Referesh
    var page: Int = -1
    var option: String = ""
    private fun getMovieListing(fetchFromRemote: Boolean = false) {
        viewModelScope.launch {
            repository
                .getMovieListing(fetchFromRemote)
                .collect { result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let { listings ->
                                state = state.copy(
                                    movieList = listings
                                )
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
    private fun upgradePage(){
        if(page>=0 && page<10){
            page+=1
        }
    }
    private fun getSelectedOption(selectedOption: String){
        option = selectedOption
    }

    //Hint
    var penalty:Int = 0
    private fun chargePenalty(){
        if (penalty >= -2 && penalty<=0){
            penalty += -1
        }
    }

    //Next button check for the 1. Answer is Correct thus Upgrade score 2.Unable Loading
    private fun checkAnswer(answer: String){
        if(option==answer){
            score=3
        }else{
            score=0
        }
    }


    init {
        getMovieListing()
        saveToDataStore(0)
        score=0
        page=0
        penalty=0
    }
}