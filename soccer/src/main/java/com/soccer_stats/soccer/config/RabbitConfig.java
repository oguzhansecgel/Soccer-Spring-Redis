package com.soccer_stats.soccer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class RabbitConfig {

    @Value("${sample.rabbitmq.exchange}")
    String exchange;

    @Value("${sample.rabbitmq.queue}")
    String queueName;

    @Value("${sample.rabbitmq.secondQueue}")
    String secondQueueName;

    @Value("${sample.rabbitmq.routingKey}")
    String routingKey;

    @Value("${sample.rabbitmq.secondRoutingKey}")
    String secondRoutingKey;

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Queue firstStepQueue(){
        return new Queue(queueName, true);
    }
    @Bean
    Queue secondStepQueue(){
        return new Queue(secondQueueName, true);
    }

    @Bean
    Binding firstBinding(Queue firstStepQueue, DirectExchange exchange){
        return BindingBuilder.bind(firstStepQueue).to(exchange).with(routingKey);
    }

    @Bean
    Binding secondBinding(Queue secondStepQueue, DirectExchange exchange){
        return BindingBuilder.bind(secondStepQueue).to(exchange).with(secondRoutingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
