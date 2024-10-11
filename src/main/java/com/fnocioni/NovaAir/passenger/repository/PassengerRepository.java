package com.fnocioni.NovaAir.passenger.repository;

import com.fnocioni.NovaAir.passenger.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Integer> {

}
