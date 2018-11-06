package com.evolvice.model.dto;

public class QueryCarDTO {
	private String externalId;
	private int productionYear;
	private BrandDTO brandDTO;
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public int getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}
	public BrandDTO getBrandDTO() {
		return brandDTO;
	}
	public void setBrandDTO(BrandDTO brandDTO) {
		this.brandDTO = brandDTO;
	}
}
