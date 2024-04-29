package com.example.moviefinal.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviefinal.presentation.theme.MovieFinalTheme
import com.example.moviefinal.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint
import com.example.moviefinal.presentation.movieDetail.view.MovieDetailScreen
import com.example.moviefinal.presentation.movieList.view.MovieListScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieFinalTheme {
                SetBarColor(color = MaterialTheme.colorScheme.inverseOnSurface)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MovieListScreen.route
                    ) {
                        composable(route = Screen.MovieListScreen.route) {
                            MovieListScreen(navController = navController)
                        }

                        composable(route = Screen.MovieDetailScreen.route + "/{${IMDB_ID}}") {
                            MovieDetailScreen(navController = navController)
                        }
                    }

                }
            }

        }
    }
    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        LaunchedEffect(key1 = color) {
            systemUiController.setSystemBarsColor(color)
        }
    }
}
