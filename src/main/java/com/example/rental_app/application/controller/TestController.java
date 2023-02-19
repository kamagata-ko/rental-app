package com.example.rental_app.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* TODO: WILL DELETE 削除予定 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> checkTestSettings(){
        return ResponseEntity.ok("OK");
    }
}
