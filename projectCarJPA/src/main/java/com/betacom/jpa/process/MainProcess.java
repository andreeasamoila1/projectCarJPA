package com.betacom.jpa.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.requests.BikeRequest;
import com.betacom.jpa.requests.CarRequest;
import com.betacom.jpa.requests.MotorcycleRequest;
import com.betacom.jpa.requests.VehicleRequest;
import com.betacom.jpa.services.interfaces.IBikeServices;
import com.betacom.jpa.services.interfaces.ICarServices;
import com.betacom.jpa.services.interfaces.IMotorcycleServices;
import com.betacom.jpa.services.interfaces.IVehicleServices;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class MainProcess {

	@Autowired
	private IVehicleServices vehicleService;
	@Autowired
	private ICarServices carService;
	@Autowired
	private IMotorcycleServices motorcycleService;
	@Autowired
	private IBikeServices bikeService;

	public void execute() {

		try {
			VehicleRequest vehicle = new VehicleRequest();
			vehicle.setVehicleType("Car");
			vehicle.setBrand("Ford");
			vehicle.setModel("Fiesta");
			vehicle.setNumberWheels(4);
			vehicle.setWheelSize(3.3);
			vehicle.setFuelType("gas");
			vehicle.setTransmission("automatic");
			vehicle.setCategory("city");
			vehicle.setColor("yellow");
			vehicle.setYear(2016);
			vehicle.setFrameMaterial("Carbon");
			vehicle.setMaxSpeed(150);

			int vehicleId = vehicleService.insert(vehicle);
			CarRequest car = new CarRequest();
			car.setNumberOfDoors(4);
			car.setPlate("TR34ERS");
			car.setBodyStyle("suv");
			car.setEngineCapacity(2000);
			car.setNumberOfGears(5);
			car.setHasNavigationSystem(false);
			car.setHasParkingSensors(true);
			car.setVehicleId(vehicleId);

			carService.create(car);

			MotorcycleRequest motorcycle = new MotorcycleRequest();
			motorcycle.setPlate("HTE49MOM");
			motorcycle.setBodyStyle("naked");
			motorcycle.setEngineCapacity(1000);
			motorcycle.setHasABS(true);
			motorcycle.setTransmissionType("diesel");
			motorcycle.setNumberOfGears(6);
			motorcycle.setVehicleId(vehicleId);

			motorcycleService.create(motorcycle);

			BikeRequest bike = new BikeRequest();
			bike.setType("electric");
			bike.setSuspensionType("none");
			bike.setFolding(false);
			bike.setBrakeType("sklaks");
			bike.setVehicleId(vehicleId);

			bikeService.create(bike);

		} catch (AcademyException e) {
			log.error(e.getMessage());
		}
	}
}
