package com.outlook.sftjun.config

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.CachingConfigurerSupport
import org.springframework.cache.interceptor.KeyGenerator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializer
import redis.clients.jedis.JedisPoolConfig

/**
 * Created by yinjun on 22/12/2017
 */
@Configuration
open class RedisConfig : CachingConfigurerSupport() {

    @Bean
    override fun cacheManager(): CacheManager {
        val cacheManager = RedisCacheManager(redisTemplate())
        cacheManager.apply {
            setDefaultExpiration(18_000)// 设置默认过期时间单位秒
        }
        return cacheManager
    }

    @Bean
    override fun keyGenerator(): KeyGenerator {
        return KeyGenerator { target, method, params ->
            val stringBuilder = StringBuilder()
            stringBuilder.apply {
                append(target.javaClass.name)
                append(method.name)
                params.forEach {
                    this.append(it.toString())
                }
            }.toString()
        }
    }

    @Bean
    open fun redisTemplate(): StringRedisTemplate {
        // must have factory
        val template = StringRedisTemplate(jedisConnectionFactory())
        template.apply {
//            valueSerializer = redisSerializer()
            afterPropertiesSet()
        }
        return template
    }

    @Bean
    open fun jedisConnectionFactory(): JedisConnectionFactory {
        val factory = JedisConnectionFactory(JedisPoolConfig())
        factory.apply {
            hostName = "127.0.0.1"
            port = 6379
            database = 0 // redis 数据库索引,默认为0
            timeout = 1_000
            password // redis 服务器连接密码,默认为空
            usePool = true
            poolConfig = jedisPoolConfig()
        }
        return factory
    }

    @Bean
    open fun jedisPoolConfig(): JedisPoolConfig {
        val poolConfig = JedisPoolConfig()
        poolConfig.apply {
            maxTotal = 50
            maxIdle = 20
            minIdle = 2
            maxWaitMillis = 300
            testOnBorrow = true
            testOnReturn = false
            testWhileIdle = true
            timeBetweenEvictionRunsMillis = 15_000
            numTestsPerEvictionRun = 5
            blockWhenExhausted = false
        }
        return poolConfig
    }

    private fun redisSerializer(): RedisSerializer<Any> {
        val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(Any::class.java)
        val om = ObjectMapper()
        om.apply {
            setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
            enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
        }
        jackson2JsonRedisSerializer.setObjectMapper(om)
        return jackson2JsonRedisSerializer
    }
}