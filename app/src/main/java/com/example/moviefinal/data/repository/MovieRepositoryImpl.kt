package com.example.moviefinal.data.repository

import com.example.moviefinal.data.remote.MovieApi
import com.example.moviefinal.data.remote.dto.MovieDetailDto
import com.example.moviefinal.data.remote.dto.MovieDto
import com.example.moviefinal.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieApi) : MovieRepository {

    override suspend fun getMovies(searchString: String): MovieDto {
        return api.getMovies(searchString = searchString)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return api.getMovieDetails(imdbId)
    }
}