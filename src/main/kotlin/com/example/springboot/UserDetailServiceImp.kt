package com.example.springboot

import com.example.springboot.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImp : UserDetailsService{
    @Autowired
    lateinit var repository: PersonRepository
    override fun loadUserByUsername(dni: String): UserDetails? {
        println("Verifying ...")
        println("DNI: $dni")

        var person = repository.findByDni(dni)
        var buider: User.UserBuilder? = null
        if (person.isPresent) {
            buider  = User.withUsername(person.get().dni)
                .password("{noop}${person.get().dni}")
                .roles(person.get().role)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)

        }else {
            println("User not found in the database!")
            throw UsernameNotFoundException("Invalid user!")
        }
        return buider?.build()

    }
}