package com.betacom.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCar;

	@Column(nullable = false)
	private Integer numberOfDoors;

	@Column(nullable = false, unique = true)
	private String plate;

	@Column(nullable = false)
	private String bodyStyle;

	@Column(nullable = false)
	private Integer engineCapacity;

	@Column(nullable = false)
	private Integer numberOfGears;

	@Column(nullable = false)
	private boolean hasNavigationSystem;

	@Column(nullable = false)
	private boolean hasParkingSensors;

	@OneToOne
	@JoinColumn(name = "vehicleId", referencedColumnName = "id")
	private Vehicle vehicle;
}
