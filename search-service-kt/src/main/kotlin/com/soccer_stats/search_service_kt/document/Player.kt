package com.soccer_stats.search_service_kt.document

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "playerss")
class Player(
    @Id val id: String? = null,
    val firstName: String,
    val lastName: String,
    val position: String,
    val height: Double,
    val weight: Double,
    val marketValue: Double,
    val positions: Set<String>,
    val currentTeamId: Int

) {
}