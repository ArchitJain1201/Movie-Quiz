package com.archit.moviequiz.domain.repostiory

import com.archit.moviequiz.domain.model.MovieListing
import com.archit.moviequiz.util.Resource
import kotlinx.coroutines.flow.Flow

interface QuizRepository {

    suspend fun getMovieListing(
        fetchFromRemote: Boolean,
    ): Flow<Resource<List<MovieListing>>>
}