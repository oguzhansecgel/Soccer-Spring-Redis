package com.soccer_stats.search_service_kt.service

import com.soccer_stats.search_service_kt.document.Player
import com.soccer_stats.search_service_kt.repository.PlayerSearchRepository
import org.springframework.amqp.rabbit.annotation.RabbitListener

import org.springframework.beans.factory.annotation.Value
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler
import com.rabbitmq.client.Channel

@Service
class PlayerService(
    private val playerSearchRepository: PlayerSearchRepository,
    searchRepository: PlayerSearchRepository

) {
    @Value("\${sample.rabbitmq.secondQueue}")
    lateinit var secondQueueName: String
    @RabbitListener(queues = ["\${sample.rabbitmq.secondQueue}"], concurrency = "3-10")
    fun createPlayer(@Payload player: Player, channel: Channel, message: Message) {
        println("Received message from ${secondQueueName}: $player")

        try {
            val playerRepo = Player(
                id = player.id,
                firstName = player.firstName,
                lastName = player.lastName,
                position = player.position,
                marketValue = player.marketValue,
                height = player.height,
                weight = player.weight,
                positions = player.positions,
                currentTeamId = player.currentTeamId
            )

            // replyTo başlığını kontrol et
            val replyToQueue = message.messageProperties.replyTo
            if (replyToQueue != null) {
                val responseMessage = "Player saved successfully".toByteArray()

                channel.basicPublish(
                    "",  // Default exchange
                    replyToQueue,  // replyTo kuyruğu
                    null,  // Ekstra özellikler
                    responseMessage  // Yanıt mesajı
                )
            }
            val savedPlayer = playerSearchRepository.save(playerRepo)

            channel.basicAck(message.messageProperties.deliveryTag, false)

            savedPlayer
        } catch (e: Exception) {
            channel.basicNack(message.messageProperties.deliveryTag, false, false)
            throw e
        }
    }

    fun getAllPlayers(): Iterable<Player>
    {
        return playerSearchRepository.findAll();
    }
    fun deleteAllPlayers()
    {
        playerSearchRepository.deleteAll();
    }
}