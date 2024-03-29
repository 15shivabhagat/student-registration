package com.crio.registration.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crio.registration.service.EasterEggService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class EasterEggController {
    
    @Autowired
    private EasterEggService easterEggService;

    @GetMapping("/hidden-feature/{number}")
    public ResponseEntity<String> getMethodName(@PathVariable("number") Integer number) {
        String message = easterEggService.generateFactAboutNumber(number);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    
}
