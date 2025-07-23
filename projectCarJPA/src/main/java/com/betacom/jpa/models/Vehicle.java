package com.betacom.jpa.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100, nullable = false)
	private String vehicleType;

	@Column(length = 100, nullable = false)
	private String brand;

	@Column(length = 100, nullable = false)
	private String model;

	@Column(nullable = false)
	private Integer numberWheels;

	@Column(nullable = false)
	private Double wheelSize;

	@Column(length = 100, nullable = false)
	private String fuelType;

	@Column(length = 100, nullable = false)
	private String transmission;

	@Column(length = 100, nullable = false)
	private String category;

	@Column(length = 100, nullable = false)
	private String color;

	@Column(nullable = false)
	private Integer year;

	@Column(length = 100, nullable = false)
	private String frameMaterial;

	@Column(nullable = false)
	private Integer maxSpeed;

	@OneToOne(mappedBy = "vehicle", cascade = CascadeType.REMOVE)
	private Car car;

	@OneToOne(mappedBy = "vehicle", cascade = CascadeType.REMOVE)
	private Bike bike;

	@OneToOne(mappedBy = "vehicle", cascade = CascadeType.REMOVE)
	private Motorcycle motorcycle;
}
