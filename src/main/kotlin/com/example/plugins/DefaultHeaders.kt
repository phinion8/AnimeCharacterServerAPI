package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.defaultheaders.*
import io.netty.handler.codec.DefaultHeaders
import io.netty.handler.codec.http.HttpHeaders
import java.time.Duration

fun Application.configureDefaultHeader() {

    install(DefaultHeaders) {
        //For how long we want the data to be cached inside the application
        val oneYearInSeconds = Duration.ofDays(365).seconds
        header(name = io.ktor.http.HttpHeaders.CacheControl, value = "public, max-age=$oneYearInSeconds, immutable")
    }


}