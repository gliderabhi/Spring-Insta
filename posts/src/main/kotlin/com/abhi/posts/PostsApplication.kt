package com.abhi.posts

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class PostsApplication

fun main(args: Array<String>) {
    runApplication<PostsApplication>(*args)
}
