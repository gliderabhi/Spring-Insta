package com.abhi.posts.controllers

import com.abhi.posts.model.InstaGenericResponse
import com.abhi.posts.model.ResponseState
import com.abhi.posts.services.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.lang.Exception

@RestController
@RequestMapping("/posts")
class InstaPostController() {

    @Autowired
    val postsService: PostService? = null

    @GetMapping("/{postId}")
    fun getPostWithId(@PathVariable postId: String): InstaGenericResponse {
        val postsRetrieved = postsService?.getPostWithId(postId)
        return InstaGenericResponse(ResponseState.SUCCESS, postsRetrieved)
    }

    @PostMapping("/user/{userId}")
    fun getAllPostsForUser(@PathVariable userId: String): InstaGenericResponse {
        return try {
            InstaGenericResponse(ResponseState.SUCCESS, postsService?.getAllPostsInTable(userId))
        } catch (e: Exception) {
            InstaGenericResponse(ResponseState.FAILURE, e)
        }
    }

    @PostMapping("/upload/{userId}")
    fun uploadPost(@RequestParam(value = "file") uploadedFile: MultipartFile, @PathVariable userId: String): InstaGenericResponse {
        return try {
            val savingPostResponse = postsService?.uploadPost(uploadedFile, userId)
            InstaGenericResponse(ResponseState.SUCCESS, savingPostResponse)
        } catch (e: Exception) {
            InstaGenericResponse(ResponseState.FAILURE, e)
        }
    }

    @GetMapping("/")
    fun getBaseIndex(): InstaGenericResponse {
        return InstaGenericResponse(ResponseState.SUCCESS, "Something is working nice")
    }
}