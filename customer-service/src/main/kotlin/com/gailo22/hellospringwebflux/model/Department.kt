package com.gailo22.hellospringwebflux.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType
import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "DEPARTMENT")
//@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType::class)
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @Column
    val name: String,

//    @Type(type = "jsonb-node")
    @Column(name = "personJson", columnDefinition = "json")
    val personJson: String
)

data class PersonSource(val name: String, val email: String): Serializable {
    constructor() : this("", "")
}