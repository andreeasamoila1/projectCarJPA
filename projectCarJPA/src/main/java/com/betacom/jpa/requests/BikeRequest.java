package com.betacom.jpa.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BikeRequest {
	
	private Integer idBike;
	private String type;
	private String suspensionType;
	private Boolean folding;
	private String brakeType;
	private Integer vehicle_id;
}
