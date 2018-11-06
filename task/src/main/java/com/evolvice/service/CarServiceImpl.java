package com.evolvice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolvice.dao.BrandRepository;
import com.evolvice.dao.CarRepository;
import com.evolvice.exception.EvolviceCustomException;
import com.evolvice.model.EvolviceModelMapper;
import com.evolvice.model.domain.Brand;
import com.evolvice.model.domain.Car;
import com.evolvice.model.dto.CreateCarDTO;
import com.evolvice.model.dto.QueryCarDTO;

@Service
@Transactional
public class CarServiceImpl implements CarService {
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public void createCar(CreateCarDTO carDTO) throws EvolviceCustomException {
		Car car = new Car();
		
	    Brand brand = brandRepository.findByExternalId(carDTO.getBrandId());
	    
	    if(brand == null) {
	      throw new EvolviceCustomException("Please enter a valid Brand ID");
	    }
	    
	    car.setBrand(brand);
		
		carRepository.save(car);
	}

	@Override
	public void updateCar(CreateCarDTO carDTO) throws EvolviceCustomException {
		Car car = carRepository.findByExternalId(carDTO.getExternalId());
        Brand brand = brandRepository.findByExternalId(carDTO.getBrandId());

		if(car == null) {
			throw new EvolviceCustomException("There is no Car with this ID");
		}

	    if(brand == null) {
	      throw new EvolviceCustomException("Please enter a valid Brand ID");
	    }
		
		car.setProductionYear(carDTO.getProductionYear());
		car.setBrand(brand);
	}

	@Override
	public void deleteCar(long id) {
		carRepository.deleteById(id);
	}

	@Override
	public QueryCarDTO getCar(String id) throws EvolviceCustomException{
		if(carRepository.findByExternalId(id)==null) {
			throw new EvolviceCustomException("No car with this ID");
		}
		Car car = carRepository.findByExternalId(id);
		return EvolviceModelMapper.convertCarEntityToQueryCarDTO(car);
	}
	
	@Override
	public List<QueryCarDTO> getAllCars() {
		List<Car> cars = carRepository.findAll();
		List<QueryCarDTO> carDTOs = new ArrayList<>();
		
		Iterator carIterator = cars.iterator();
		
		while(carIterator.hasNext()) {
			carDTOs.add(EvolviceModelMapper.convertCarEntityToQueryCarDTO((Car) carIterator.next()));
		}
		
		return carDTOs;
	}
}
