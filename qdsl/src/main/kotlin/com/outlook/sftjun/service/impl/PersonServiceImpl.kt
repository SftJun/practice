package com.outlook.sftjun.service.impl

import com.outlook.sftjun.domain.Person
import com.outlook.sftjun.repository.PersonRepository
import com.outlook.sftjun.service.PersonService
import com.querydsl.core.types.dsl.BooleanExpression
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

/**
 * Created by yinjun on 20/12/2017
 */
@Service
class PersonServiceImpl : PersonService {

    @Autowired lateinit var personRepository: PersonRepository

    override fun save(person: Person): Person {
        return personRepository.save(person)
    }

    override fun update(person: Person): Person {
        //TODO
        return save(person)
    }

    override fun findOneBy(predicate: BooleanExpression): Person? {
        return personRepository.findOne(predicate)
    }

    override fun findAllBy(predicate: BooleanExpression): List<Person> {
        return personRepository.findAll(predicate).toList()
    }

    override fun findAllBy(predicate: BooleanExpression, pageRequest: PageRequest): Page<Person> {
        return personRepository.findAll(predicate, pageRequest)
    }
}