package com.example.springboot.repository

import com.example.springboot.entity.Person
import org.springframework.data.repository.CrudRepository
import java.util.*

interface PersonRepository : CrudRepository<Person, Long> {
    fun deleteByDni(dni: String)
    fun findByDni(dni: String): Optional<Person>
}