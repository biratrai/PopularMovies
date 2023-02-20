package com.gooner10.network

import com.gooner10model.Movie
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Class to generate instance of Retrofit Service
 */
class RetrofitServiceGenerator private constructor() : PopularMoviesNetworkDataSource {
    init {
        throw AssertionError("Cannot instantiate private constructor")
    }

    private val networkApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
//                .addInterceptor(
                    // TODO: Decide logging logic
//                    HttpLoggingInterceptor().apply {
//                        setLevel(HttpLoggingInterceptor.Level.BODY)
//                    }
//                )
                .build()
        )
//        .addConverterFactory(
//            @OptIn(ExperimentalSerializationApi::class)
//            networkJson.asConverterFactory("application/json".toMediaType())
//        )
        .build()
        .create(RetrofitPopularMoviesNetworkApi::class.java)

    companion object {

        private var builder: Retrofit.Builder? = null
        private const val BASE_URL = "http://api.themoviedb.org/3/discover/"
        private val httpClient = OkHttpClient()

        private fun getBuilder(): Retrofit.Builder {
            if (builder == null) {
                builder = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
            }
            return builder!!
        }

        fun <S> createService(serviceClass: Class<S>): S {
            val retrofit = getBuilder()
                    .client(httpClient)
                    .build()
            return retrofit.create(serviceClass)
        }
    }

    override suspend fun getPopularMovies(order: String): List<Movie?>? {
        return networkApi.getMoviesByPopularity(order, "530c5cfd24953abae83df3e614c6d774").data.movieList
    }

}
