package com.soccer_stats.search_service_kt.config

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {


    @Bean
    fun jsonMessageConverter(): Jackson2JsonMessageConverter
    {
        return Jackson2JsonMessageConverter();
    }
}