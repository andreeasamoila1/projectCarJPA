package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer>{

}
