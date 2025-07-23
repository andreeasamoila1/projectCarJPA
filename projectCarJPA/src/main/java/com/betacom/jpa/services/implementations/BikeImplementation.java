package com.betacom.jpa.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Bike;
import com.betacom.jpa.repositories.IBikeRepository;
import com.betacom.jpa.requests.BikeRequest;
import com.betacom.jpa.services.interfaces.IBikeServices;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BikeImplementation implements IBikeServices {

	@Autowired
	private IBikeRepository bikeRepository;

	@Override
	public Integer insert(BikeRequest bikeReq) throws AcademyException {
		log.debug("Insert :" + bikeReq);
		Bike bike = new Bike();
		Optional<Bike> b = bikeRepository.findById(bikeReq.getIdBike());

		bike.setType(bikeReq.getType());
		bike.setSuspensionType(bikeReq.getSuspensionType());
		bike.setFolding(bikeReq.getFolding());
		bike.setBrakeType(bikeReq.getBrakeType());

		return bikeRepository.save(bike).getId();
	}

}
