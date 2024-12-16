package com.soccer_stats.search_service_kt.repository

import com.soccer_stats.search_service_kt.model.Player
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : ElasticsearchRepository<Player , String> {
}