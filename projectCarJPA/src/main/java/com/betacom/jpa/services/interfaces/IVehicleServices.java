package com.betacom.jpa.services.interfaces;

import org.springframework.stereotype.Service;

import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.requests.VehicleRequest;

@Service
public interface IVehicleServices {

	Integer insert(VehicleRequest vehicleReq) throws AcademyException;
	
}
