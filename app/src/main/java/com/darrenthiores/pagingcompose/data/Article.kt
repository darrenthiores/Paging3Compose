package com.darrenthiores.pagingcompose.data

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Article(
    val id: Int,
    val title: String,
    val description: String,
    val date: LocalDateTime,
)

val Article.createdText: String get() = articleDateFormatter.format(date)

private val articleDateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
