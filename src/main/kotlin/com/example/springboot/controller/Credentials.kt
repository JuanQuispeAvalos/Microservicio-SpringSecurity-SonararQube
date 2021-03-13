package com.example.springboot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Credentials {
    @GetMapping("/public")
    fun public(): String {
        return "public"
    }

    @GetMapping("/authenticated")
    fun authenticated(): String {
        return "authenticated"
    }

    @GetMapping("/role/user")
    fun roleUser(): String {
        return "roleUser"
    }

    @GetMapping("/role/admin")
    fun roleAdmin(): String {
        return "roleAdmin"
    }

}
