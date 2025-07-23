package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Bike;

@Repository
public interface IBikeRepository extends JpaRepository<Bike, Integer>{

}
