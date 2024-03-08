package com.abhi.authentication.services

import com.abhi.insta.model.InstaErrorCodes
import com.abhi.insta.model.InstaException
import com.abhi.authentication.model.InstaUser
import com.abhi.authentication.model.RegisterRequest
import com.abhi.authentication.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime

@Service
class UserService {
    @Autowired
    private var userRepository: UserRepository? = null

    fun registerUser(registerRequest: RegisterRequest /*profilePicData: MultipartFile*/): InstaUser {
        val registerResponse = userRepository?.save(InstaUser(
                userId = "UID${LocalDateTime.now()}${registerRequest.name}",
                name = registerRequest.name,
                email = registerRequest.email,
                mobileNo = registerRequest.mobileNo,
                profilePic = ByteArray(0)
        ))
                ?: throw InstaException(InstaErrorCodes.SERVER_ERROR, "Failed to register, try again")
        return registerResponse
    }

    fun getUserDetails(userId: String): InstaUser {
        val instaUser = userRepository?.findById(userId)?.get()
                ?: throw InstaException(InstaErrorCodes.SERVER_ERROR, "No user found")
        return instaUser
    }


}