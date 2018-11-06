package com.evolvice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.evolvice.exception.EvolviceCustomException;
import com.evolvice.model.dto.CreateCarDTO;
import com.evolvice.model.dto.QueryCarDTO;
import com.evolvice.service.CarService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	CarService carService;

	@GetMapping("{id}")
	@ApiOperation(value="Find Car By id", notes="get the car by its external id")
	public ResponseEntity getCarById(@PathVariable String id) {
		QueryCarDTO queryCarDTO = null;
		try{
			queryCarDTO = carService.getCar(id);
		}catch (EvolviceCustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(queryCarDTO,HttpStatus.OK);
	}
	
	@GetMapping
	@ApiOperation(value="a method to list all the cars")
	public ResponseEntity<List> getAllCars() {
		return new ResponseEntity<List>(carService.getAllCars(), HttpStatus.OK);
	}

	@PutMapping
	@ApiOperation(value="Update existing car")
	public ResponseEntity<String> updateCar(@RequestBody CreateCarDTO carDTO) {
		try {
			carService.updateCar(carDTO);
		} catch (EvolviceCustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create new Car")
	public ResponseEntity<String> createCar(@RequestBody CreateCarDTO carDTO) {
		try {
			carService.createCar(carDTO);
		} catch (EvolviceCustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping
	public void deleteCar(@PathVariable("id")int id) {
		carService.deleteCar(id);
	}
}
