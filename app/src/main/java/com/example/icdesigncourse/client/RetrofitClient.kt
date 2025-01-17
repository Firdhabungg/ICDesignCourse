package com.example.icdesigncourse.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "http://192.168.123.36:80/icdesign/index.php/"
    val url = "http://192.168.123.36/icdesign/gambar/"

    val instance:Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        retrofit.create(Api::class.java)
    }
}