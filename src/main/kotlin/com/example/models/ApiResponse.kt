package com.example.models

import kotlinx.serialization.Serializable

@Serializable
//To be able to send this api response class we need to be able to serialize it
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<Hero> = emptyList(),
    val lastUpdated: Long? = null
)
