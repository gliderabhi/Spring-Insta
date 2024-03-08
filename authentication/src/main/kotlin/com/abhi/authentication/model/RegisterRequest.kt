package com.abhi.authentication.model

data class RegisterRequest(
        val name : String,
        val email : String,
        val password : String,
        val mobileNo : String
)
