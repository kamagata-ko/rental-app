package com.example.rental_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles(value = "integration")
public abstract class AbstractApplicationTest {

    // 通信を行うライブラリー(Test用)
    @Autowired
    protected WebTestClient webTestClient;

}
