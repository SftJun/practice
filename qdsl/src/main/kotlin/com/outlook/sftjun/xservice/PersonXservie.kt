package com.outlook.sftjun.xservice

import com.outlook.sftjun.domain.po.PersonPO
import com.outlook.sftjun.domain.vo.PersonVO

/**
 * Created by yinjun on 20/12/2017
 */
interface PersonXservie {

    fun add(po: PersonPO): PersonVO
}