package com.betacom.jpa.services.interfaces;

import org.springframework.stereotype.Service;

import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.requests.BikeRequest;

@Service
public interface IBikeServices {

	void create(BikeRequest bikeReq) throws AcademyException;

}
