package com.abhi.insta.model

data class InstaException(
        val errorCode: InstaErrorCodes,
        val errorMessage: String,
)