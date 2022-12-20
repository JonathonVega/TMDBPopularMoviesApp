package com.jonathonfvega.tmdbpopularmoviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jonathonfvega.tmdbpopularmoviesapp.presentation.ui.Screen
import com.jonathonfvega.tmdbpopularmoviesapp.presentation.ui.movieDetails.MovieDetailsViewModel
import com.jonathonfvega.tmdbpopularmoviesapp.presentation.ui.theme.TMDBPopularMoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TMDBPopularMoviesAppTheme {
                val navController = rememberNavController()
                val movieDetailsViewModel: MovieDetailsViewModel = viewModel()

                NavHost(navController = navController, startDestination = Screen.MoviesGrid.route) {
                    composable(route = Screen.MoviesGrid.route) { navBackStackEntry ->
                        MovieGridScreen(
                            onNavigation = navController::navigate
                        )
                    }
                    composable(
                        route = Screen.MoviesDetails.route + "/{movie_id}",
                        arguments = listOf(navArgument("movie_id") { type = NavType.IntType }),
                    ) { navBackStackEntry ->
                        MoviesDetailsScreen(
                            onNavigation = navController::navigate,
                            viewModel = movieDetailsViewModel,
                            movieId = navBackStackEntry.arguments?.getInt("movie_id") ?: 0
                        )
                    }

                }
            }
        }
    }
}