package com.example.icdesigncourse.response.account

data class AkunResponse(
    val username: String,
    val password: String,
    val nama_lengkap: String,
    val kelas_paket: String,
    val email: String,
    val foto_profil: String
)
