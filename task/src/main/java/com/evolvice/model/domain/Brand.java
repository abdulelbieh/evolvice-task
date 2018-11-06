package com.evolvice.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@Column(name="BRAND")
	private String brand;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="FIRST_RELEASE_YEAR")
	private int firstReleaseYear;

	@Column(name="LAST_RELEASE_YEAR")
	private int lastReleaseYear;
	
	@Column(name="NOTES")
	private String notes;
	
	@Column(name="EXTERNAL_ID", unique = true, nullable = false)
	private String externalId;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getFirstReleaseYear() {
		return firstReleaseYear;
	}
	public void setFirstReleaseYear(int firstReleaseYear) {
		this.firstReleaseYear = firstReleaseYear;
	}
	public int getLastReleaseYear() {
		return lastReleaseYear;
	}
	public void setLastReleaseYear(int lastReleaseYear) {
		this.lastReleaseYear = lastReleaseYear;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
}
