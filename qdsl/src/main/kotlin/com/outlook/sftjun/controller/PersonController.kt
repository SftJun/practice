package com.outlook.sftjun.controller

import com.outlook.sftjun.domain.po.PersonPO
import com.outlook.sftjun.domain.vo.PersonVO
import com.outlook.sftjun.xservice.PersonXservie
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Created by SftJun on 20/12/2017
 */
@Api("人员")
@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired lateinit var personXservie: PersonXservie

    @ApiOperation("添加人员")
    @PostMapping("/add")
    @ResponseBody
    fun add(@Valid @RequestBody po: PersonPO): PersonVO {
        return personXservie.add(po)
    }
}