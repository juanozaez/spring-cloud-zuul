package com.homelab.springcloudzuul

import com.github.tomakehurst.wiremock.WireMockServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@EnableZuulProxy
class SpringCloudZuulApplication

fun main(args: Array<String>) {
    runApplication<SpringCloudZuulApplication>(*args)
    stubUserService()
}

fun stubUserService() {
    WireMockServer(8090).start()
}

@Configuration
class Config{
    @Bean
    fun filter() = LoggingFilter()
}
