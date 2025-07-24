package com.betacom.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bikes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Bike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBike;

	@Column(nullable = false)
	private String type;

	@Column(nullable = false)
	private String suspensionType;

	@Column(nullable = false)
	private Boolean folding;

	@Column(nullable = false)
	private String brakeType;

	@OneToOne
	@JoinColumn(name = "vehicleId", referencedColumnName = "id")
	private Vehicle vehicle;
}
