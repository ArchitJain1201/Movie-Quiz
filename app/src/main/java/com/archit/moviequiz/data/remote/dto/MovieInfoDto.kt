package com.archit.moviequiz.data.remote.dto

import com.squareup.moshi.Json

data class MovieInfoDto(
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "option1") val option1: String?,
    @field:Json(name = "option2") val option2: String?,
    @field:Json(name = "option3") val option3: String?,
    @field:Json(name = "option4") val option4: String?,
    @field:Json(name = "actor") val actor: String?,
    @field:Json(name = "img_url") val imgUrl: String?,
    @field:Json(name = "movie_by") val movieBy: String?,
)
