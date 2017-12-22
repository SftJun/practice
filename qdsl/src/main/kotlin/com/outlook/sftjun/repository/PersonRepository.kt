package com.outlook.sftjun.repository

import com.outlook.sftjun.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QueryDslPredicateExecutor

/**
 * Created by SftJun on 20/12/2017
 */
interface PersonRepository : JpaRepository<Person, Long>
        , QueryDslPredicateExecutor<Person>