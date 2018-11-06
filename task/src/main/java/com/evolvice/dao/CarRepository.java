package com.evolvice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evolvice.model.domain.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
	Car findByExternalId(String externalId);
}
