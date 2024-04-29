package com.example.moviefinal.presentation.movieDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviefinal.domain.usecase.getmoviedetail.GetMovieDetailUseCase
import com.example.moviefinal.util.Constants.IMDB_ID
import com.example.moviefinal.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val stateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _state = mutableStateOf(MovieDetailState())
    val state: State<MovieDetailState> = _state

    init {
        stateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }

    private fun getMovieDetail(imdbId: String) {
        getMovieDetailUseCase.execute(imdbId).onEach {it->
            when (it) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(movie = it.data)
                }

                is Resource.Error -> {
                    _state.value = MovieDetailState(error = it.message ?: "Error")
                }

                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }

                else -> {

                }
            }
        }.launchIn(viewModelScope)

    }

    fun retry() {
        stateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }
    }
}