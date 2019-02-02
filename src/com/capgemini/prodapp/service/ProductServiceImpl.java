package com.capgemini.prodapp.service;

import java.util.List;

import com.capgemini.prodapp.bean.ProductBean;
import com.capgemini.prodapp.dao.ProductDaoImpl;
import com.capgemini.prodapp.exception.ProductException;

public class ProductServiceImpl implements IProductService {

	@Override
	public Integer addProductDetails(ProductBean product) throws ProductException {
		ProductDaoImpl prodDao=new ProductDaoImpl();
		return prodDao.addProductDetails(product);
	}

	
	@Override
	public List<Integer> retriveOwnerId() throws ProductException {
		// TODO Auto-generated method stub
		ProductDaoImpl prodDao=new ProductDaoImpl();
		return prodDao.retriveOwnerId();
		
	}

}
