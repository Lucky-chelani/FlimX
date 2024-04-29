package com.example.moviefinal.presentation.movieDetail

import com.example.moviefinal.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error: String = ""
)