package com.example.icdesigncourse.client

import com.example.icdesigncourse.response.account.AkunResponse
import com.example.icdesigncourse.response.account.RegisterResponse
import com.example.icdesigncourse.response.akun.LoginResponse
import com.example.icdesigncourse.response.modul.ModulResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    // tampilkan akun berdasarkan username
    @GET("Akun")
    fun getAkun(
        @Query("username") username: String
    ): Call<AkunResponse>
    // Login
    @FormUrlEncoded
    @POST("Akun")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponse>
//    registrasi
    @FormUrlEncoded
    @POST("Akun/register")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("nama_lengkap") namaLengkap: String
    ): Call<RegisterResponse>
//    tampilkan modul
    @GET("Modul")
    fun getModul(): Call<ArrayList<ModulResponse>>

}