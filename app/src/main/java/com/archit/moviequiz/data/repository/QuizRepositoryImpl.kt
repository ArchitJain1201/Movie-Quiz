package com.archit.moviequiz.data.repository

import com.archit.moviequiz.data.local.QuizDatabase
import com.archit.moviequiz.data.mapper.toMovieListing
import com.archit.moviequiz.data.mapper.toMovieListingEntity
import com.archit.moviequiz.data.remote.QuizApi
import com.archit.moviequiz.domain.model.MovieListing
import com.archit.moviequiz.domain.repostiory.QuizRepository
import com.archit.moviequiz.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuizRepositoryImpl @Inject constructor(
    private val api: QuizApi,
    private val db: QuizDatabase
): QuizRepository {

    private val dao = db.dao

    override suspend fun getMovieListing(
        fetchFromRemote: Boolean,
    ): Flow<Resource<List<MovieListing>>> {
        return flow {
            emit(Resource.Loading(true))

            val localListing =dao.getAllMovieListing()
            emit(Resource.Success(
                data = localListing.map { it.toMovieListing() }
            ))

            val isDbEmpty = localListing.isEmpty()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote

            if(shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListings = try {
                api.getMovieInfo()
                // if a API call is made it tell the compiler to parse it to a usable form
                //The Problem here is that the response that we are receiving
                // from the server we have to make it into a list
            } catch(e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

            remoteListings?.let { listings ->
                dao.clearMovieListings()
                dao.insertMovieListings(
                    listings.map { it.toMovieListingEntity() }
                )
                // here the data is cached
                emit(Resource.Success(
                    data = dao.getAllMovieListing().map { it.toMovieListing() }
                ))
                emit(Resource.Loading(false))
            }

        }
    }
}