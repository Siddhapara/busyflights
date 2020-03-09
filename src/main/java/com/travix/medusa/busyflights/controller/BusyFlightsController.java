package com.travix.medusa.busyflights.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.service.BusyFlightsService;

@RestController
public class BusyFlightsController {

    @Autowired
    private BusyFlightsService busyFlightsService;

    @PostMapping(value = "/search")
    public ResponseEntity<?> search(@RequestBody BusyFlightsRequest busyFlightsRequest) throws InterruptedException, ExecutionException{
    	return busyFlightsService.search(busyFlightsRequest);
    }

}
