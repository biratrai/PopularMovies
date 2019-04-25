package com.gooner10.popularmoviesapp.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class to generate instance of Retrofit Service
 */
public class RetrofitServiceGenerator {
    private RetrofitServiceGenerator() {
        throw new AssertionError("Cannot instantiate private constructor");
    }

    private static Retrofit.Builder builder;
    private static final String BASE_URL = "http://api.themoviedb.org/3/discover/";
    private static OkHttpClient httpClient = new OkHttpClient();

    private static Retrofit.Builder getBuilder() {
        if (builder == null) {
            builder = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
        }
        return builder;
    }

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = getBuilder()
                .client(httpClient)
                .build();
        return retrofit.create(serviceClass);
    }

}
