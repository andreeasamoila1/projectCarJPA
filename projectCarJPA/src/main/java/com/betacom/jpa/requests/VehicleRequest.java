package com.betacom.jpa.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VehicleRequest {

	private Integer id;
	private String vehicleType;
	private String brand;
	private String model;
	private Integer numberWheels;
	private Double wheelSize;
	private String fuelType;
	private String transmission;
	private String category;
	private String color;
	private Integer year;
	private String frameMaterial;
	private Integer maxSpeed;
}
