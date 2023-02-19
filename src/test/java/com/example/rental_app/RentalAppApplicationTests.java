package com.example.rental_app;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


class RentalAppApplicationTests extends AbstractApplicationTest {

    @Test
    void IS_TEST_CONTROLLER_ACCEPT_SUCCESS() {
        webTestClient.get()
                .uri("/test")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(message -> assertEquals(message, "OK"));
    }

    @Test
    void IS_TEST_CONTROLLER_ACCEPT_FAILURE() {
        webTestClient.get()
                .uri("/test")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(message -> assertNotEquals(message, "ERROR"));
    }

}
