package com.betacom.jpa.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Motorcycle;
import com.betacom.jpa.models.Vehicle;
import com.betacom.jpa.repositories.IMotorcycleRepository;
import com.betacom.jpa.repositories.IVehicleRepository;
import com.betacom.jpa.requests.MotorcycleRequest;
import com.betacom.jpa.services.interfaces.IMotorcycleServices;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MotorcycleImplementation implements IMotorcycleServices {

	@Autowired
	private IMotorcycleRepository motorcycleRepository;
	@Autowired
	IVehicleRepository vehicleRepository;

	@Override
	public void create(MotorcycleRequest motorcycleReq) throws AcademyException {
		log.debug("Insert :" + motorcycleReq);
		Motorcycle motorcycle = new Motorcycle();
		Optional<Vehicle> v = vehicleRepository.findById(motorcycleReq.getVehicleId());

		if (v.isPresent())
			throw new AcademyException("This motorcycle exists in he database");

		motorcycle.setPlate(motorcycleReq.getPlate());
		motorcycle.setBodyStyle(motorcycleReq.getBodyStyle());
		motorcycle.setEngineCapacity(motorcycleReq.getEngineCapacity());
		motorcycle.setHasABS(motorcycleReq.isHasABS());
		motorcycle.setTransmissionType(motorcycleReq.getTransmissionType());
		motorcycle.setNumberOfGears(motorcycleReq.getNumberOfGears());
		motorcycle.setVehicle(v.get());

		motorcycleRepository.save(motorcycle);
	}

}
