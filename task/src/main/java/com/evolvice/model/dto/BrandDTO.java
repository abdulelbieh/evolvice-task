package com.evolvice.model.dto;

public class BrandDTO {
	
	private String brand;
	private String model;
	private int firstReleaseYear;
	private int lastReleaseYear;
	private String notes;
	private String externalId;

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
