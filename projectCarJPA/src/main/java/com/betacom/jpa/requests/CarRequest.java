package com.betacom.jpa.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CarRequest {

	private Integer idCar;
	private Integer numberOfDoors;
	private String plate;
	private String bodyStyle;
	private Integer engineCapacity;
	private Integer numberOfGears;
	private boolean hasNavigationSystem;
	private boolean hasParkingSensors;
	private Integer vehicleId;
}
