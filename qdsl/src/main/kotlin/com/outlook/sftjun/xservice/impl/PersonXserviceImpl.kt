package com.outlook.sftjun.xservice.impl

import com.outlook.sftjun.domain.Person
import com.outlook.sftjun.domain.po.PersonPO
import com.outlook.sftjun.domain.vo.PersonVO
import com.outlook.sftjun.service.PersonService
import com.outlook.sftjun.xservice.PersonXservie
import org.apache.commons.beanutils.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by SftJun on 20/12/2017
 */
@Service
class PersonXserviceImpl : PersonXservie {

    @Autowired lateinit var personService: PersonService

    override fun add(po: PersonPO): PersonVO {
        val person = Person()
        BeanUtils.copyProperties(person, po)
        val result = personService.save(person)
        val vo = PersonVO()
        BeanUtils.copyProperties(vo, result)
        return vo
    }

    override fun findOneById(id: Long): PersonVO? {
        val person = personService.findOneById(id)
        person ?: return null
        val vo = PersonVO()
        BeanUtils.copyProperties(vo, person)
        return vo
    }
}