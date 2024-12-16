package com.soccer_stats.search_service.repository;

import com.soccer_stats.search_service.document.Player;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends ElasticsearchRepository<Player, String> {
}
