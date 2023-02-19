package com.example.rental_app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractApplicationTest {

    /* Test Container で利用するイメージの設定 */
    @Container
    protected static PostgreSQLContainer<?> database = new PostgreSQLContainer<>("postgres:15-alpine")
            .withDatabaseName("testdb")
            .withUsername("testUser")
            .withPassword("test");
    // 通信を行うライブラリー(Test用)
    @Autowired
    protected WebTestClient webTestClient;

    @AfterAll
    protected void start() {
        database.start();
    }

    @BeforeAll
    protected void stop() {
        database.stop();
    }


}
