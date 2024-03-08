package com.abhi.authentication.repository

import com.abhi.authentication.model.InstaUser
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<InstaUser, String>{
}