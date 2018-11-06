package com.evolvice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolvice.dao.BrandRepository;
import com.evolvice.exception.EvolviceCustomException;
import com.evolvice.model.EvolviceModelMapper;
import com.evolvice.model.domain.Brand;
import com.evolvice.model.dto.BrandDTO;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
	@Autowired
	BrandRepository brandRepository;

	@Override
	public void addBrand(BrandDTO brandDTO) throws EvolviceCustomException {
		Brand brand = EvolviceModelMapper.convertBrandDTOtoBrand(brandDTO);
		
		if(brandDTO.getExternalId().equals("") || brandDTO.getExternalId()==null) {
			throw new EvolviceCustomException("External ID can't be null or Empty");
		}
		else if(brandDTO.getModel().equals("") || brandDTO.getModel()==null){
			throw new EvolviceCustomException("The Model can not be null or Empty");
		}
		else if(brandDTO.getBrand().equals("") || brandDTO.getBrand()==null){
			throw new EvolviceCustomException("The Brand can not be null or Empty");
		}
		else if(brandDTO.getLastReleaseYear()!= 0 && brandDTO.getFirstReleaseYear()>brandDTO.getLastReleaseYear()) {
			throw new EvolviceCustomException("The Brand frist Release year and last release must have a valid range");
		}
		else if(brandRepository.findByExternalId(brandDTO.getExternalId()) != null) {
			throw new EvolviceCustomException("There is already a brand with same External ID, please enter a new one");
		}

		brandRepository.save(brand);
	}
	
	@Override
	public List<BrandDTO> getAllBrands() {
		List<Brand> brands = brandRepository.findAll();
		List<BrandDTO> brandDTOlist = new ArrayList<>();
		Iterator<Brand> brandIterator = brands.iterator();
		
		while(brandIterator.hasNext()) {
			brandDTOlist.add(EvolviceModelMapper.convertBrandtoBrandDTO((Brand)brandIterator.next()));
		}
		
		return brandDTOlist;
	}
}
