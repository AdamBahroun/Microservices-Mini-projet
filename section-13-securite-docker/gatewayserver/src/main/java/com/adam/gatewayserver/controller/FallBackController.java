package com.adam.gatewayserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @RequestMapping("/contactAdmin")
    public ResponseEntity<String> contactAdmin() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("An error occurred. Please contact the administrator. !");
    }
}
