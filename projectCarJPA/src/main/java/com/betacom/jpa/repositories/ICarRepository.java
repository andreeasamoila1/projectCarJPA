package com.betacom.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Integer>{

	Optional<Car> findByPlate(String plate);
}
