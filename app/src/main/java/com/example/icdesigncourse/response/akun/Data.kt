package com.example.icdesigncourse.response.akun

data class Data(
        val username: String,
        val password: String,
        val nama_lengkap: String,
        val kelas_paket: String,
        val email: String,
        val foto_profil: String
    )