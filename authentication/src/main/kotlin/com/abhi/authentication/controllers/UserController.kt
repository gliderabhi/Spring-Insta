package com.abhi.authentication.controllers


import com.abhi.authentication.model.RegisterRequest
import com.abhi.authentication.services.UserService
import com.abhi.insta.model.InstaException
import com.abhi.insta.model.InstaGenericResponse
import com.abhi.insta.model.ResponseState
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.lang.Exception

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private var userService: UserService? = null

    @PostMapping("/register")
    fun registerUser(@RequestBody registerRequest: RegisterRequest, /*@RequestParam(value = "profile_pic") uploadedFile: MultipartFile*/): InstaGenericResponse {
        return try {
            InstaGenericResponse(ResponseState.SUCCESS, userService?.registerUser(registerRequest/*, uploadedFile*/))
        } catch (e: InstaException) {
            InstaGenericResponse(ResponseState.FAILURE, e)
        }
    }

    @PostMapping("/{userId}")
    fun getUserDetails(@PathVariable userId: String): InstaGenericResponse {
        return try {
            InstaGenericResponse(ResponseState.SUCCESS, userService?.getUserDetails(userId))
        } catch (e: InstaException) {
            InstaGenericResponse(ResponseState.FAILURE, e)
        }
    }


}