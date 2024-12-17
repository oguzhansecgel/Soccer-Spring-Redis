package com.soccer_stats.search_service_kt.repository

import com.soccer_stats.search_service_kt.document.Player
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerSearchRepository : ElasticsearchRepository<Player,String> {
}