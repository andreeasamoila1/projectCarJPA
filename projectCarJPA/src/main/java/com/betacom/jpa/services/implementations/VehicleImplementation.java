package com.betacom.jpa.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Vehicle;
import com.betacom.jpa.repositories.IVehicleRepository;
import com.betacom.jpa.requests.VehicleRequest;
import com.betacom.jpa.services.interfaces.IVehicleServices;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class VehicleImplementation implements IVehicleServices {

	@Autowired
	private IVehicleRepository vehicleRepository;

	@Override
	public Integer insert(VehicleRequest vehicleReq) throws AcademyException {
		log.debug("Insert :" + vehicleReq);
		Vehicle vehicle = new Vehicle();
		Optional<Vehicle> v = vehicleRepository.findById(vehicleReq.getId());

		if (v.isPresent())
			throw new AcademyException("This vehicle exists in the database");

		vehicle.setVehicleType(vehicleReq.getVehicleType());
		vehicle.setBrand(vehicleReq.getBrand());
		vehicle.setModel(vehicleReq.getModel());
		vehicle.setNumberWheels(vehicleReq.getNumberWheels());
		vehicle.setWheelSize(vehicleReq.getWheelSize());
		vehicle.setFuelType(vehicleReq.getFuelType());
		vehicle.setTransmission(vehicleReq.getTransmission());
		vehicle.setCategory(vehicleReq.getCategory());
		vehicle.setColor(vehicleReq.getColor());
		vehicle.setYear(vehicleReq.getYear());
		vehicle.setFrameMaterial(vehicleReq.getFrameMaterial());
		vehicle.setMaxSpeed(vehicleReq.getMaxSpeed());

		return vehicleRepository.save(vehicle).getId();
	}

}
