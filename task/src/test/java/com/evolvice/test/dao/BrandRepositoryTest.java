package com.evolvice.test.dao;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.evolvice.dao.BrandRepository;
import com.evolvice.model.domain.Brand;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class BrandRepositoryTest {
	@Autowired
	BrandRepository brandRepository;
	
	@Test
	public void testSaveBrand() {
		Brand brand = new Brand();
		
		brand.setBrand("Dummy Brand");
		brand.setModel("Dummy Model");
		brand.setFirstReleaseYear(1990);
		brand.setLastReleaseYear(1995);
		brand.setExternalId("dummyBrand1");
		
		brandRepository.save(brand);
		
		assert(brandRepository.findByExternalId("dummyBrand1")!=null);
		
	}
}
