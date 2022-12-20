package com.jonathonfvega.tmdbpopularmoviesapp.network

import com.jonathonfvega.tmdbpopularmoviesapp.network.model.MovieCreditsDto
import com.jonathonfvega.tmdbpopularmoviesapp.util.Constants
import com.jonathonfvega.tmdbpopularmoviesapp.network.model.MovieDetailsDto
import com.jonathonfvega.tmdbpopularmoviesapp.network.response.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int
    ): PopularMoviesResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id", encoded = true) movieId: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): MovieDetailsDto

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): MovieCreditsDto

}