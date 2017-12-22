package com.outlook.sftjun.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.*

/**
 * Created by SftJun on 22/12/2017
 */
@Api("Redis")
@RestController
@RequestMapping("/redis")
class RedisController {

    private val logger = LoggerFactory.getLogger(this::class.java)
    @Autowired lateinit var redisTemplate: StringRedisTemplate

    @ApiOperation("根据key取得redis中的值")
    @GetMapping("/find/{key}")
    @ResponseBody
    fun get(@PathVariable key: String): String {
        logger.debug("redis get value of key: $key")
        val result = redisTemplate.opsForValue().get(key)
        println(result)
        return result.toString()
    }

    @ApiOperation("添加key为name的值")
    @GetMapping("/add/{name}")
    fun add(@PathVariable name: String) {
        redisTemplate.opsForValue().set("name", name)
    }
}