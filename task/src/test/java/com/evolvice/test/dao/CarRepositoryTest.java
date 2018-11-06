package com.evolvice.test.dao;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.evolvice.dao.BrandRepository;
import com.evolvice.dao.CarRepository;
import com.evolvice.model.domain.Brand;
import com.evolvice.model.domain.Car;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class CarRepositoryTest {
	@Autowired
	protected CarRepository carRepository;
	
	@Autowired
	protected BrandRepository brandRepository;
	
	@Test
	public void testSaveCar() {
		Brand brand = new Brand();
		brand.setExternalId("l1");
		brandRepository.save(brand);
		
		int numberofCarsBeforeCreation = carRepository.findAll().size();
		
		Car car = new Car();
		car.setBrand(brand);
		car.setExternalID("c1");
		car.setProductionYear(1990);
		

		carRepository.save(car);
		
		int numberOfCarsAfterCreation = carRepository.findAll().size();
		
		
		assert(numberofCarsBeforeCreation == numberOfCarsAfterCreation-1);
	}
	
	@Test
	public void testDeleteCar() {
		Brand brand = new Brand();
		brand.setExternalId("b1");
		brandRepository.save(brand);
		
		Car car = new Car();
		car.setBrand(brand);
		car.setExternalID("c11");
		car.setProductionYear(1990);
		
		carRepository.save(car);
		carRepository.delete(car);
		
		assert(carRepository.findByExternalId("c11")==null);
	}
}
