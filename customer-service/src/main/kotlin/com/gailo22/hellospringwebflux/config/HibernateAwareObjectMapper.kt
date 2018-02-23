package com.gailo22.hellospringwebflux.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module

class HibernateAwareObjectMapper : ObjectMapper() {
    init {
        registerModule(Hibernate5Module())
    }
}