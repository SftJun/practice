package com.outlook.sftjun.service.impl

import com.outlook.sftjun.domain.Person
import com.outlook.sftjun.repository.PersonRepository
import com.outlook.sftjun.service.PersonService
import com.querydsl.core.types.dsl.BooleanExpression
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by SftJun on 20/12/2017
 */
@Service
open class PersonServiceImpl : PersonService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Autowired lateinit var personRepository: PersonRepository

    override fun save(person: Person): Person {
        return personRepository.save(person)
    }

    //    @CachePut(cacheNames = arrayOf("person"))
    @CachePut(key = "#person.id.toString()", value = "person", condition = "#result != null")
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

    /**
     * unless 与 sync 互斥
     */
    //    @Cacheable(cacheNames = arrayOf("person"))
    @Cacheable(key = "#id.toString()", value = "person", sync = true)
    @Transactional(readOnly = true)
    override fun findOneById(id: Long): Person? {
        val person = personRepository.findOne(id)
        logger.debug("从数据库中取出ID:$id 的Person")
        return person
    }
}