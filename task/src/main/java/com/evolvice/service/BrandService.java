package com.evolvice.service;

import java.util.List;

import com.evolvice.exception.EvolviceCustomException;
import com.evolvice.model.dto.BrandDTO;

public interface BrandService {
	void addBrand(BrandDTO brandDTO) throws EvolviceCustomException;
	List<BrandDTO> getAllBrands();
}
