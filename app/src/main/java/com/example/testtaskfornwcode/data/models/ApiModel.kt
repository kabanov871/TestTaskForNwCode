package com.example.testtaskfornwcode.data.models

data class ApiModel(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)