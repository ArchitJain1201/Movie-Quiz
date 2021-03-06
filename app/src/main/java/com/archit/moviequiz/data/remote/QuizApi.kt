package com.archit.moviequiz.data.remote

import com.archit.moviequiz.data.remote.dto.MovieInfoDto
import retrofit2.http.GET

interface QuizApi {
    @GET("/movie")
    suspend fun getMovieInfo(): List<MovieInfoDto>

    companion object{
        const val BASE_URL ="http://127.0.0.1:5000"
    }
}