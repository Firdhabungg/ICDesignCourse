package com.example.icdesigncourse.response.account

data class RegisterResponse(
    val success: Boolean,
    val message: String,
    val data: UserData?
)

data class UserData(
    val username: String
)
