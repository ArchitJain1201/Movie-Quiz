package com.archit.moviequiz.data.mapper

import com.archit.moviequiz.data.local.MovieListingEntity
import com.archit.moviequiz.data.remote.dto.MovieInfoDto
import com.archit.moviequiz.domain.model.MovieListing

fun MovieListingEntity.toMovieListing(): MovieListing {
 return MovieListing(
     name = name,
     option1 = option1,
     option2 = option2,
     option3 = option3,
     option4 = option4,
     actor = actor,
     imgUrl = imgUrl,
     movieBy = movieBy
 )
}
fun MovieListing.toMovieListingEntity(): MovieListingEntity {
    return  MovieListingEntity(
        name = name,
        option1 = option1,
        option2 = option2,
        option3 = option3,
        option4 = option4,
        actor = actor,
        imgUrl = imgUrl,
        movieBy = movieBy
    )
}

fun MovieInfoDto.toMovieListingEntity(): MovieListingEntity {
    return  MovieListingEntity(
        name = name!!,
        option1 = option1!!,
        option2 = option2!!,
        option3 = option3!!,
        option4 = option4!!,
        actor = actor!!,
        imgUrl = imgUrl!!,
        movieBy = movieBy!!
    )
}