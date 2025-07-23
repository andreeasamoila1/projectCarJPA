package com.betacom.jpa.services.interfaces;

import org.springframework.stereotype.Service;

import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.requests.BikeRequest;

@Service
public interface IBikeServices {

	Integer insert(BikeRequest bikeReq) throws AcademyException;

}
