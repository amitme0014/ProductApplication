package com.capgemini.prodapp.bean;

public class ProductBean {
	private Integer productNumber;
	private Integer ownerId;
	private Integer productType;
	private Double productPrice;
	
	private Integer ownerIdProductOwner;
	
	
	
	
	public ProductBean() {
		super();
	}
	
	

	public ProductBean(Integer ownerIdProductOwner) {
		super();
		this.ownerIdProductOwner = ownerIdProductOwner;
	}



	public ProductBean(Integer productNumber, Integer ownerId, Integer productType2, Double productPrice) {
		super();
		this.productNumber = productNumber;
		this.ownerId = ownerId;
		this.productType = productType2;
		this.productPrice = productPrice;
	}

	public Integer getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
	

	public Integer getOwnerIdProductOwner() {
		return ownerIdProductOwner;
	}



	public void setOwnerIdProductOwner(Integer ownerIdProductOwner) {
		this.ownerIdProductOwner = ownerIdProductOwner;
	}



	@Override
	public String toString() {
		return "ProductBean [productNumber=" + productNumber + ", ownerId=" + ownerId + ", productType=" + productType
				+ ", productPrice=" + productPrice + "]";
	}
	
	
	
	

}
