package com.example.icdesigncourse.client

import com.example.icdesigncourse.response.account.RegisterResponse
import com.example.icdesigncourse.response.akun.LoginResponse
import com.example.icdesigncourse.response.modul.ModulResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @GET("Modul")
    fun getModul(): Call<ArrayList<ModulResponse>>

    @FormUrlEncoded
    @POST("Akun")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("Register")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("nama_lengkap") namaLengkap: String,
    ): Call<RegisterResponse>
}