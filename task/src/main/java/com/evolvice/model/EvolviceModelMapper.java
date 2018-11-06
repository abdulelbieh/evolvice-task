package com.evolvice.model;

import org.modelmapper.ModelMapper;

import com.evolvice.model.domain.Brand;
import com.evolvice.model.domain.Car;
import com.evolvice.model.dto.BrandDTO;
import com.evolvice.model.dto.CreateCarDTO;
import com.evolvice.model.dto.QueryCarDTO;

public class EvolviceModelMapper {
	private static ModelMapper modelMapper = new ModelMapper();

	public static QueryCarDTO convertCarEntityToQueryCarDTO(Car car) {
		QueryCarDTO carDTO = new QueryCarDTO();
		
		carDTO.setExternalId(car.getExternalId());
		carDTO.setBrandDTO(convertBrandtoBrandDTO(car.getBrand()));
		carDTO.setProductionYear(car.getProductionYear());
		
		return carDTO;
	}

	public static Brand convertBrandDTOtoBrand(BrandDTO brandDTO) {
		Brand brand = new Brand();
		
		brand.setBrand(brandDTO.getBrand());
		brand.setExternalId(brandDTO.getExternalId());
		brand.setFirstReleaseYear(brandDTO.getFirstReleaseYear());
		brand.setLastReleaseYear(brandDTO.getLastReleaseYear());
		brand.setModel(brandDTO.getModel());
		brand.setNotes(brandDTO.getNotes());
		
		return brand;
	}
	
	public static BrandDTO convertBrandtoBrandDTO(Brand brand) {
        BrandDTO brandDTO = new BrandDTO();
		
		brandDTO.setBrand(brand.getBrand());
		brandDTO.setExternalId(brand.getExternalId());
		brandDTO.setFirstReleaseYear(brand.getFirstReleaseYear());
		brandDTO.setLastReleaseYear(brand.getLastReleaseYear());
		brandDTO.setModel(brand.getModel());
		brandDTO.setNotes(brand.getNotes());
		
		return brandDTO;
	}
}
