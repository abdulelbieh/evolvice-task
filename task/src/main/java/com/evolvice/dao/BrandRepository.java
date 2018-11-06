package com.evolvice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evolvice.model.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long>{
	Brand findByExternalId(String externalId);
}
