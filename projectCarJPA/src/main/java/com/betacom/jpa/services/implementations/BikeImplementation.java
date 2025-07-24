package com.betacom.jpa.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Bike;
import com.betacom.jpa.models.Vehicle;
import com.betacom.jpa.repositories.IBikeRepository;
import com.betacom.jpa.repositories.IVehicleRepository;
import com.betacom.jpa.requests.BikeRequest;
import com.betacom.jpa.services.interfaces.IBikeServices;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BikeImplementation implements IBikeServices {

	@Autowired
	private IBikeRepository bikeRepository;

	@Autowired
	private IVehicleRepository vehicleRepository;

	@Override
	public void create(BikeRequest bikeReq) throws AcademyException {
		log.debug("Create:" + bikeReq);
		Bike bike = new Bike();
		Optional<Vehicle> v = vehicleRepository.findById(bikeReq.getVehicleId());
		if (v.isPresent())
			throw new AcademyException("This bike exists in the database");

		bike.setType(bikeReq.getType());
		bike.setSuspensionType(bikeReq.getSuspensionType());
		bike.setFolding(bikeReq.getFolding());
		bike.setBrakeType(bikeReq.getBrakeType());
		bike.setVehicle(v.get());

		bikeRepository.save(bike);
	}

}
