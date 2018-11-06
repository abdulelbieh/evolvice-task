package com.evolvice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolvice.exception.EvolviceCustomException;
import com.evolvice.model.dto.BrandDTO;
import com.evolvice.service.BrandService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/brand")
public class BrandsController {
	@Autowired
	BrandService brandService;
	
	@GetMapping
	@ApiOperation(value="A method to list all brands")
	public List<BrandDTO> getAllBrands() {
		return brandService.getAllBrands();
	}
	
	@PostMapping
	@ApiOperation(value="A method to add a brand")
	public ResponseEntity addBrand(@RequestBody BrandDTO brandDTO) {
		try {
			brandService.addBrand(brandDTO);
		} catch (EvolviceCustomException exception) {
			return new ResponseEntity<>(exception.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
