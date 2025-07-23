package com.betacom.jpa.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Car;
import com.betacom.jpa.repositories.ICarRepository;
import com.betacom.jpa.requests.CarRequest;
import com.betacom.jpa.services.interfaces.ICarServices;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CarImplementation implements ICarServices{

	@Autowired
	private ICarRepository carRepository;
	
	@Override
	public Integer insert(CarRequest carReq) throws AcademyException {
		log.debug("Insert :" + carReq);
		Car car = new Car();
		Optional<Car> c = carRepository.findByPlate(carReq.getPlate());
		
		if(c.isPresent())
			throw new AcademyException("This car exists in the database");
		
		car.setNumberOfDoors(carReq.getNumberOfDoors());
		car.setPlate(carReq.getPlate());
		car.setBodyStyle(carReq.getBodyStyle());
		car.setEngineCapacity(carReq.getEngineCapacity());
		car.setNumberOfGears(carReq.getNumberOfGears());
		car.setHasNavigationSystem(carReq.isHasNavigationSystem());
		car.setHasParkingSensors(carReq.isHasParkingSensors());
		
		return carRepository.save(car).getId();
	}

}
