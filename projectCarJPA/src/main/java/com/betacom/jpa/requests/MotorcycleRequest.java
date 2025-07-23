package com.betacom.jpa.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MotorcycleRequest {

private Integer idMotorcycle;
	private String plate;
	private String bodyStyle;
	private Integer engineCapacity;
	private boolean hasABS;
	private String transmissionType;
	private int numberOfGears;
	private Integer vehicle_id;
}
