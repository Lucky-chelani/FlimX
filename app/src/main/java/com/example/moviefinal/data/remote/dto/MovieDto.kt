package com.example.moviefinal.data.remote.dto

import com.example.moviefinal.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: List<Search>,
    val totalResults: String
)

fun MovieDto.toMovieList(): List<Movie> {
    return search.map { search -> Movie(search.imdbID, search.year, search.title, search.poster) }

}