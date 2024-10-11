package com.fnocioni.NovaAir.passenger.controller;

import com.fnocioni.NovaAir.passenger.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @PostMapping
    public Object add(@RequestParam(value = "firstName") String firstName,
                      @RequestParam(value = "lastName") String lastName){

        int newRecordID = passengerService.insertPassengerRecord(firstName, lastName);

        return ResponseEntity.ok("New passenger added with id: " + newRecordID);
    }
}
