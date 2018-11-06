package com.evolvice.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	@ManyToOne
	private Brand brand;

	@Column(name="PRODUCTION_YEAR")
	private int productionYear;
	
	@Column(name="EXTERNAL_ID")
	private String externalId;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public int getProductionYear() {
		return productionYear;
	}


	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}


	public String getExternalId() {
		return this.externalId;
	}


	public void setExternalID(String externalId) {
		this.externalId = externalId;
	}

}
