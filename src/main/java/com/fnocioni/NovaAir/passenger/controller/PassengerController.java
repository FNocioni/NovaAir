package com.fnocioni.NovaAir.passenger.controller;

import com.fnocioni.NovaAir.passenger.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @PostMapping
    public Object add(@RequestParam Map<String, String> params){

        String firstName = params.get("firstName");
        String lastName = params.get("lastName");
        String email = params.get("email");
        String password = params.get("password");

        if(Objects.isNull(firstName) || Objects.isNull(lastName) || Objects.isNull(email) || Objects.isNull(password) ||
            firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }

        int newRecordID = passengerService.insertPassengerRecord(firstName, lastName, email, password);

        return ResponseEntity.ok("New passenger added with id: " + newRecordID);
    }

    @GetMapping
    public Object getAll(){
        return passengerService.getAllPassengers();
    }
}
