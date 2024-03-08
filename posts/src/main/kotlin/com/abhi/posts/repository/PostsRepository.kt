package com.abhi.posts.repository

import com.abhi.posts.model.InstaPosts
import org.springframework.data.jpa.repository.JpaRepository

interface PostsRepository : JpaRepository<InstaPosts, String> {

    fun findAllByPostedBy(userId: String): List<InstaPosts>
}