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
        po.id = null
        val person = Person()
        BeanUtils.copyProperties(person, po)
        val result = personService.save(person)
        return convert2VO(result)
    }

    override fun findOneById(id: Long): PersonVO? {
        val person = personService.findOneById(id)
        person ?: return null
        return convert2VO(person)
    }

    override fun update(po: PersonPO): PersonVO {
        val person = personService.findOneById(po.id!!)
        BeanUtils.copyProperties(person, po)
        val result = personService.update(person!!)
        return convert2VO(result)
    }

    fun convert2VO(person: Person): PersonVO {
        val vo = PersonVO()
        BeanUtils.copyProperties(vo, person)
        return vo
    }
}