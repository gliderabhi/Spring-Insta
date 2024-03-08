package com.abhi.posts.services

import com.abhi.posts.model.InstaErrorCodes
import com.abhi.posts.model.InstaException
import com.abhi.posts.model.InstaGenericResponse
import com.abhi.posts.model.ResponseState
import com.abhi.posts.model.InstaPosts
import com.abhi.posts.repository.PostsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.time.Clock
import java.time.LocalDateTime

@Service
class PostService {

    @Autowired
    private var postsRepository: PostsRepository? = null

    fun getAllPostsInTable(userId: String) : List<InstaPosts>{
        val foundPosts =  postsRepository?.findAllByPostedBy(userId)
        if(foundPosts == null) {
            throw InstaException(InstaErrorCodes.NOT_FOUND, "")
        }else {
            return foundPosts
        }
    }

    fun getPostsForUser(userID: String): List<InstaPosts> {
        return listOf(postsRepository?.getReferenceById("2024-03-07T22:03:09.60612110") ?: InstaPosts())
    }

    fun uploadPost(uploadedFile: MultipartFile, userId: String): InstaPosts {
        val convertedContent = uploadedFile.bytes
        val postSaved = postsRepository?.save(InstaPosts(postData = convertedContent, postId = LocalDateTime.now().toString(), postedBy = userId))
                ?: throw InstaException(InstaErrorCodes.SERVER_ERROR, "Could not save post")
        return postSaved
    }

    fun getPostWithId(postId: String): InstaPosts {
        val postFound = postsRepository?.findById(postId)?.get()
                ?: throw InstaException(InstaErrorCodes.SERVER_ERROR, "Could not save post")
        return postFound
    }
}