package com.abhi.insta.model

data class InstaGenericResponse(
        val responseStatus: ResponseState,
        val responseData: Any?
)