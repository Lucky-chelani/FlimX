package com.example.moviefinal.presentation.movieList

import com.example.moviefinal.domain.model.Movie

data class MovieListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = "",
    val searchString: String = "Batman"
)