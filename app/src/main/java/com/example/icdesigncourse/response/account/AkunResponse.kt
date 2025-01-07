package com.example.icdesigncourse.response.account


data class AkunResponse(
    val username: String,
    val email: String,
    val password: String,
    val nama_lengkap: String,
    val kelas_paket: String
)
