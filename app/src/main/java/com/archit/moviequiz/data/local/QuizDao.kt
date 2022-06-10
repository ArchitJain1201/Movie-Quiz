package com.archit.moviequiz.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuizDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieListings(
        companyListingEntities: List<MovieListingEntity>
    )

    @Query("DELETE FROM movielistingentity")
    suspend fun clearMovieListings()

    @Query("SELECT * FROM movielistingentity")
    fun getAll(): List<MovieListingEntity>

}