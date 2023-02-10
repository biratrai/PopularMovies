package com.gooner10.popularmoviesapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Class to generate instance of Retrofit Service
 */
class RetrofitServiceGenerator private constructor() {
    init {
        throw AssertionError("Cannot instantiate private constructor")
    }

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

}
