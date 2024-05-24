package com.example.airodata.controller;

import com.example.airodata.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/airport/")
//@RequiredArgsConstructor
public class AirportController {
    @Autowired
    private AirportService airportService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void airportAddedToDataBase() {
        airportService.airportAddedToDataBase();
    }


}
