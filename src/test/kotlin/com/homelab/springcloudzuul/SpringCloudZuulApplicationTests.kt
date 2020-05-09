package com.homelab.springcloudzuul

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringCloudZuulApplicationTests {

    @Test
    fun contextLoads() {
        stubUserService()

    }

    fun stubUserService(){
        WireMockServer(8090).start()
        stubFor(get(urlEqualTo("/user-service")).willReturn(aResponse().withBody("I'm the user-service!")))
    }

}
