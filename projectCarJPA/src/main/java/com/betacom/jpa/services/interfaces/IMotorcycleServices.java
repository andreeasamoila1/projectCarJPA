package com.betacom.jpa.services.interfaces;

import org.springframework.stereotype.Service;

import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.requests.MotorcycleRequest;

@Service
public interface IMotorcycleServices {

	void create(MotorcycleRequest motorcycleReq) throws AcademyException;

}
