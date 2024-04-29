package com.example.moviefinal.domain.repository

import com.example.moviefinal.data.remote.dto.MovieDetailDto
import com.example.moviefinal.data.remote.dto.MovieDto

interface MovieRepository {
    suspend fun getMovies(searchString: String): MovieDto
    suspend fun getMovieDetail(imdbId: String): MovieDetailDto
}