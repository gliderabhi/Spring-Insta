package com.abhi.posts.model

data class InstaGenericResponse(
        val responseStatus: ResponseState,
        val responseData: Any?
)