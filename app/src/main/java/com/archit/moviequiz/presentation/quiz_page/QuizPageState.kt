package com.archit.moviequiz.presentation.quiz_page

import com.archit.moviequiz.domain.model.MovieListing

data class QuizPageState(
    val movieList:List<MovieListing> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)