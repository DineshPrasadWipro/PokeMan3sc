package com.zm.pokemon.injection

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.zm.pokemon.respository.NetworkInterface
import com.zm.pokemon.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    // Provide Gson
    single<Gson> {
        GsonBuilder().create()
    }

    // Provide HttpLoggingInterceptor
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    // Provide OkHttpClient
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    // Provide Retrofit
    single<Retrofit> {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(Constants.BASEURL)
            .addConverterFactory(GsonConverterFactory.create(get<Gson>()))
            .build()
    }

    // Provide NetworkInterface
    single<NetworkInterface> {
        get<Retrofit>().create(NetworkInterface::class.java)
    }
}

