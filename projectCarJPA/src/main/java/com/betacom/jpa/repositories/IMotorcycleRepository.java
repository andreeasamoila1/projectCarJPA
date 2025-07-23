package com.betacom.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Motorcycle;

@Repository
public interface IMotorcycleRepository extends JpaRepository<Motorcycle, Integer> {

	Optional<Motorcycle> findByPlate(String plate);
}
