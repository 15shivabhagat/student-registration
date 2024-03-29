package com.crio.registration.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class EasterEggService {

    private static final String url = "http://numbersapi.com/";


    public String generateFactAboutNumber(Integer number) {
        RestTemplate restTemplate = new RestTemplate();
        String message = restTemplate.getForObject(url+"/"+number, String.class);
        return message;
    }
    
}
