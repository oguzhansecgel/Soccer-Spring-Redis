    package com.soccer_stats.search_service_kt.service

    import com.soccer_stats.search_service_kt.model.Player
    import com.soccer_stats.search_service_kt.repository.PlayerRepository
    import org.springframework.amqp.rabbit.annotation.RabbitListener
    import org.springframework.cache.annotation.Cacheable
    import org.springframework.stereotype.Service

    @Service
    class PlayerService(val playerRepository: PlayerRepository) {

        @RabbitListener(queues = ["\${sample.rabbitmq.secondServiceQueue}"])
        fun createPlayer(player: Player) : Player {
            val playerSearch = Player(
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
           return playerRepository.save(playerSearch)
        }

        @Cacheable(value = ["playerKT"])
        fun getPlayers(): Iterable<Player> {
            return playerRepository.findAll()
        }

    }