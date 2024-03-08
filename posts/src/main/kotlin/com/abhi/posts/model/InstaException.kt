package com.abhi.posts.model

import java.lang.Exception

data class InstaException(
        val errorCode: InstaErrorCodes,
        val errorMessage: String,
) : Exception()