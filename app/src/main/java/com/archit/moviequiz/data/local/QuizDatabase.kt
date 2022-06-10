package com.archit.moviequiz.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MovieListingEntity::class],
    version = 1
)
abstract class QuizDatabase: RoomDatabase() {
    abstract val dto: QuizDao
}