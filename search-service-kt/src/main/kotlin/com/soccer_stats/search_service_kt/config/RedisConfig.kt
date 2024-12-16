package com.soccer_stats.search_service_kt.config

import lombok.RequiredArgsConstructor
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.RedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@RequiredArgsConstructor
@Configuration
@EnableCaching
class RedisConfig {

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        return LettuceConnectionFactory("localhost", 6379)
    }

    @Bean(value = ["cacheManager"])
    fun redisCacheManager(redisConnectionFactory: RedisConnectionFactory?): CacheManager {
        val redisCacheConfiguration: org.springframework.data.redis.cache.RedisCacheConfiguration =
            org.springframework.data.redis.cache.RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer<Any>(RedisSerializer.json()))
        redisCacheConfiguration.usePrefix()

        // Null kontrolü ekleniyor
        return if (redisConnectionFactory != null) {
            RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration).build()
        } else {
            throw IllegalStateException("RedisConnectionFactory cannot be null")
        }
    }

    @Bean
    fun cacheConfiguration(): org.springframework.data.redis.cache.RedisCacheConfiguration {
        return org.springframework.data.redis.cache.RedisCacheConfiguration.defaultCacheConfig()
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair
                    .fromSerializer<Any>(GenericJackson2JsonRedisSerializer())
            )
    }

    @Bean
    fun redisTemplate(connectionFactory: RedisConnectionFactory?): RedisTemplate<String, Any> {
        val template: RedisTemplate<String, Any> = RedisTemplate<String, Any>()
        template.setConnectionFactory(connectionFactory)

        val serializer: GenericJackson2JsonRedisSerializer = GenericJackson2JsonRedisSerializer()

        template.setDefaultSerializer(serializer)
        template.setKeySerializer(StringRedisSerializer())
        template.setValueSerializer(serializer)
        template.setHashKeySerializer(StringRedisSerializer())
        template.setHashValueSerializer(serializer)

        return template
    }
}