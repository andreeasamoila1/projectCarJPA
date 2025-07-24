package com.betacom.jpa.services.interfaces;

import org.springframework.stereotype.Service;

import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.requests.CarRequest;

@Service
public interface ICarServices {

	void create(CarRequest carReq) throws AcademyException;

}
