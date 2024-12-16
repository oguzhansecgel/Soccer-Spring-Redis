package com.soccer_stats.search_service_kt.model

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.DateFormat
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.time.LocalDate

@Document(indexName = "plays")
data class Player(
    @Id val id: String? = null,

    val firstName: String,
    val lastName: String,
    val position: String,



    val height: Double? = null,
    val weight: Double? = null,
    val marketValue: Double? = null,

    val positions: Set<String>? = null,
    val currentTeamId: Int? = null
){


}