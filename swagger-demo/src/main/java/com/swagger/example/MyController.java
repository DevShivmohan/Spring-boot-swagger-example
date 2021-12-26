package com.swagger.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping(value = "/api/response")
    public ResponseEntity<?> response(){
        return new ResponseEntity<>("Hello in Swagger with Spring boot",HttpStatus.OK);
    }
}
