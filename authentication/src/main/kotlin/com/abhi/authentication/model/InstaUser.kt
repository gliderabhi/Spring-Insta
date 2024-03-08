package com.abhi.authentication.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.Table

@Entity
@Table(name = "insta_user")
data class InstaUser(
        @Id
        val userId: String = "",
        val name: String = "",
        val email: String = "",
        val mobileNo: String = "",

        @Lob
        @Column(length = Int.MAX_VALUE, columnDefinition = "LONGBLOB")
        val profilePic: ByteArray? = null
)