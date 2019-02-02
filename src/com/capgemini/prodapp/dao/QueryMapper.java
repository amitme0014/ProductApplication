package com.capgemini.prodapp.dao;

public interface QueryMapper {
	public static final String INSERT_QUERY="INSERT INTO product VALUES(prod_seq.NEXTVAL,?,?,?)";
	//public static final String VIEW_EMPLOYEE_QUERY="SELECT owner_id,owner_name,number,product_number,product_type,product_price FROM product_owners,product WHERE  owner_id=?";
	public static final String PRODUCTID_QUERY="SELECT prod_seq.CURRVAL FROM DUAL";
	public static final String ViewProductOwnerId="SELECT OWNER_ID FROM PRODUCT_OWNERS";

}
