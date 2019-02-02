package com.capgemini.prodapp.exception;

public class ProductException extends Exception {
	String message;
	
	public ProductException(){
		
	}

	public ProductException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}

}
