package com.archit.moviequiz.presentation.quiz_page

import com.archit.moviequiz.domain.model.MovieListing

data class QuizPageState(
    val movieList:List<MovieListing> = emptyList(),
    val id: Int = -1,
    val isLoading: Boolean = false,
    val error: String? = null
)