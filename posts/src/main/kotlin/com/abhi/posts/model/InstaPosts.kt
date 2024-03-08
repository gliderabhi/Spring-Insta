package com.abhi.posts.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table

@Entity
@Table(name = "insta_posts")
data class InstaPosts(
        @Id
        val postId: String = "",
        val postedBy: String = "",
        val createdOn: String = "",
        val isDeleted: String = "",
        val noOfLikes: String = "",
        val noComments: String = "",
        @Lob
        @Column(length = Int.MAX_VALUE, columnDefinition = "LONGBLOB")
        val postData: ByteArray? = null
)