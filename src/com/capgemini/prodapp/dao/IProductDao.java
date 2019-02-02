package com.capgemini.prodapp.dao;

import java.util.List;

import com.capgemini.prodapp.bean.ProductBean;
import com.capgemini.prodapp.exception.ProductException;

public interface IProductDao {
	public Integer addProductDetails(ProductBean product) throws ProductException;
//	public ProductBean viewProductDetails(Double empId) throws ProductException;
	public List<Integer> retriveOwnerId()throws ProductException;



}
