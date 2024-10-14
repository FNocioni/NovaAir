package com.fnocioni.NovaAir.passenger.service;


import com.fnocioni.NovaAir.passenger.entity.PassengerEntity;
import com.fnocioni.NovaAir.passenger.repository.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public int insertPassengerRecord(String firstName, String lastName, String email, String password){
        PassengerEntity entity = new PassengerEntity();
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setEmail(email);
        entity.setPassword(password);

        entity = passengerRepository.save(entity);

        return entity.getPassengerId();
    }

    public List<PassengerEntity> getAllPassengers(){
        return passengerRepository.findAll();
    }
}
