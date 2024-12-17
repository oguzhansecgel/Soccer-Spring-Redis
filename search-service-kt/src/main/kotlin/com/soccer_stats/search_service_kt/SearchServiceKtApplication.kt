package com.soccer_stats.search_service_kt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@SpringBootApplication
@EnableElasticsearchRepositories
class SearchServiceKtApplication


fun main(args: Array<String>) {
	runApplication<SearchServiceKtApplication>(*args)
}
