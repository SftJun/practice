package com.outlook.sftjun.xservice

import com.outlook.sftjun.domain.po.PersonPO
import com.outlook.sftjun.domain.vo.PersonVO

/**
 * Created by SftJun on 20/12/2017
 */
interface PersonXservie {

    fun add(po: PersonPO): PersonVO

    fun findOneById(id: Long): PersonVO?

    fun update(po: PersonPO): PersonVO
}