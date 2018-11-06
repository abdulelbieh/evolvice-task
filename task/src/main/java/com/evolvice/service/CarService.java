package com.evolvice.service;

import java.util.List;

import com.evolvice.exception.EvolviceCustomException;
import com.evolvice.model.dto.CreateCarDTO;
import com.evolvice.model.dto.QueryCarDTO;

public interface CarService {
	void createCar(CreateCarDTO car) throws EvolviceCustomException;
	void updateCar(CreateCarDTO car) throws EvolviceCustomException;
	QueryCarDTO getCar(String id) throws EvolviceCustomException;
	void deleteCar(long id);
	List<QueryCarDTO> getAllCars();
}
