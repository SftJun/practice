package com.outlook.sftjun

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

/**
 * Created by yinjun on 20/12/2017
 */
@SpringBootApplication
@EnableConfigurationProperties
open class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
