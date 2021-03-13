package com.example.springboot.entity

import javax.persistence.*

@Entity
data class Person(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSONA")
    @SequenceGenerator(name = "SEQ_PERSONA", sequenceName = "SEQ_PERSONA",  allocationSize = 1)
    var id: Long? = null,
    var dni: String? = null,
    var role: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
)