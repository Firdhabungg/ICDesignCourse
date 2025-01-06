package com.example.icdesigncourse.response.account

data class RegisterResponse(
    val username: String,
    val email: String,
    val password: String,
    val nama_lengkap: String,
)
