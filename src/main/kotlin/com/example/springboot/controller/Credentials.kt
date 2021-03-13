package com.example.springboot.controller

import org.springframework.boot.json.BasicJsonParser
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Credentials {
    @GetMapping("/public")
    fun public(): String {
        return "Hello World!"
    }

    @GetMapping("/authenticated")
    fun authenticated(): String {
        val auth: Authentication = SecurityContextHolder.getContext().authentication
        return "${auth.name} is now an authenticated user!"
    }

    @GetMapping("/role/user")
    fun roleUser(): String {
        val auth: Authentication = SecurityContextHolder.getContext().authentication
        return "${auth.name} has a USER role"
    }

    @GetMapping("/role/admin")
    fun roleAdmin(): String {
        val auth: Authentication = SecurityContextHolder.getContext().authentication
            return "${auth.name} has a ADMIN role"
    }

}
