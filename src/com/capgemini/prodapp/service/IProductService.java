package com.capgemini.prodapp.service;

import java.util.List;

import com.capgemini.prodapp.bean.ProductBean;
import com.capgemini.prodapp.exception.ProductException;


public interface IProductService {
	public Integer addProductDetails(ProductBean product) throws ProductException;
	//public ProductBean viewProductDetails(Double empId) throws ProductException;
	public List<Integer> retriveOwnerId()throws ProductException;

}
