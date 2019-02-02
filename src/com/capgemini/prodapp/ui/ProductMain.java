package com.capgemini.prodapp.ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.prodapp.bean.ProductBean;
import com.capgemini.prodapp.dao.QueryMapper;
import com.capgemini.prodapp.exception.ProductException;
import com.capgemini.prodapp.service.IProductService;
import com.capgemini.prodapp.service.ProductServiceImpl;
import com.capgemini.prodapp.util.DBConnection;

public class ProductMain {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Menu:");
		System.out.println("-----------------------------");
		System.out.println("1. Buy Product");
		System.out.println("2. Exit");
		Integer option=sc.nextInt();
					
		switch (option) {
		case 1:addingProduct(sc);
				break;
		case 2:exit();
		}
	}
	
	private static void exit() {
			System.out.println("Thank you");
			System.exit(0);
	}
	
	private static void addingProduct(Scanner sc) {
		//System.out.println("Enter Owner Id[10,20,30]: ");
		//Double ownerId=sc.nextDouble();
		IProductService productService = null;
		productService = new ProductServiceImpl();
		try {
			List<Integer> ownerIdList = productService.retriveOwnerId();
			Iterator<Integer> ownerList = ownerIdList.iterator();
			System.out.print("Existing Product Owner IDS Are:-[");
			while(ownerList.hasNext()){
				System.out.print(ownerList.next() + ",");
			}
			System.out.print("]");
		} catch (ProductException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//complete this
		}
		System.out.println();
		System.out.println("Please enter your product owner id from above list:");
		Integer ownerId=sc.nextInt();
		if (ownerId==10||ownerId==20||ownerId==30){
			Integer productType;
			do{
				System.out.println("Select Product Type (1-CatProduct, 2-DogProduct):");
				productType=sc.nextInt();
			}while(productType!=1&&productType!=2);
			Double productPrice;
			do{
				System.out.println("Enter product price Rs:");
				productPrice=sc.nextDouble();
			}while(productPrice<=0);
			//if((productType==1||productType==2)&&productPrice>0){
			ProductBean product=new ProductBean(null,ownerId,productType,productPrice);
			try{
				//System.out.println("hi");
				Integer productNumber=addProductDetails(product);
				System.out.println("Product successfully ordered. Order id:<"+productNumber+">");
				}catch(ProductException e){
					e.printStackTrace();
				}
		}else {
			System.out.println("Owner does not exists");
				//}
					//}
		}
	}

	/*private static void retriveOwnerId() {
		try(
				Connection connection =DBConnection.getInstance().getConnection();
				Statement statement=connection.createStatement();
				){
				ResultSet resultSet=statement.executeQuery(QueryMapper.ViewProductOwnerId);
				System.out.println();
				System.out.print("Existing Product Owner IDS Are:-[");
				while(resultSet.next()){
					System.out.print(resultSet.getInt(1) + ",");
				}
				System.out.print("]");
		}catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ProductException e1) {
			e1.printStackTrace();
		}
	}
*/
	private static Integer addProductDetails(ProductBean product) throws ProductException {
		IProductService productService= new ProductServiceImpl();
		return productService.addProductDetails(product);
	}

}
