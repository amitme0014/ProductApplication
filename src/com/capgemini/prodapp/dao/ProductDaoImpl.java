package com.capgemini.prodapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.prodapp.bean.ProductBean;
import com.capgemini.prodapp.exception.ProductException;
import com.capgemini.prodapp.util.DBConnection;

public class ProductDaoImpl implements IProductDao {
	Logger logger=Logger.getRootLogger();
	
	public ProductDaoImpl(){
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}

	@Override
	public Integer addProductDetails(ProductBean product) throws ProductException {
		try(
				Connection connection= DBConnection.getInstance().getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);
				
			){
			//preparedStatement.setDouble(1,product.getProductNumber());
			preparedStatement.setInt(1,product.getOwnerId());
			preparedStatement.setInt(2,product.getProductType());
			preparedStatement.setDouble(3,product.getProductPrice());
			
			int n=preparedStatement.executeUpdate();
			if(n!=1){
				logger.error("Unable to insert employee details");
				throw new ProductException("Unable to insert employee details");
			}
			PreparedStatement p=connection.prepareStatement(QueryMapper.PRODUCTID_QUERY);
			ResultSet resultSet=p.executeQuery();
			if(resultSet.next())
			{
				Integer productNumber=resultSet.getInt(1);
				logger.info("Employee record successfully inserted");
				return productNumber;
				
			}else{
				logger.warn("Failed to generate empid");
				throw new ProductException("Failed to generate empid");
			}
		}catch(SQLException e){
			logger.error(e.getMessage());
			throw new ProductException(e.getMessage());
			
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new ProductException(e.getMessage());
		}
	}

	@Override
	public List<Integer> retriveOwnerId() throws ProductException {
		// TODO Auto-generated method stub
		Connection connection= DBConnection.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Integer> ownerList = new ArrayList<Integer>();
		try {
			 preparedStatement=connection.prepareStatement(QueryMapper.ViewProductOwnerId);
			 resultSet = preparedStatement.executeQuery();
			 while(resultSet.next()){
				 Integer ownerId = resultSet.getInt(1);
				 ownerList.add(ownerId);
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//rethrow custom exception here
			e.printStackTrace();
		}
		return ownerList;
	}

	/*@Override
	public List<ProductBean> retriveAllDetails(Double ownerId) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
	

}
