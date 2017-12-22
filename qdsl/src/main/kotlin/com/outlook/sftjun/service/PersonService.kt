package com.outlook.sftjun.service

import com.outlook.sftjun.domain.Person
import com.querydsl.core.types.dsl.BooleanExpression
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

/**
 * Created by SftJun on 20/12/2017
 */
interface PersonService {

    fun save(person: Person): Person

    fun update(person: Person): Person

    fun findOneBy(predicate: BooleanExpression): Person?

    fun findAllBy(predicate: BooleanExpression): List<Person>

    fun findAllBy(predicate: BooleanExpression, pageRequest: PageRequest): Page<Person>
}