package com.example.moviefinal.presentation.movieList

sealed class MovieListEvent {
    data class Search(val searchString: String) : MovieListEvent()
}