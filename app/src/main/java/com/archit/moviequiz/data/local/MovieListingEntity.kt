package com.archit.moviequiz.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieListingEntity(
    val name:String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val actor: String,
    val imgUrl: String,
    val movieBy: String,
    @PrimaryKey val id: Int? = null
)
