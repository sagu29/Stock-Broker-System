package com.masai;
import java.util.ArrayList;
import java.util.List;
public class Customer {
	String cName;
	int cNumOfStocks;
	String cUserId;
	String cPassword;
	int customerId;
	List<Stock> cS;
	static int i = 0;
	
	public Customer() {
		
	}
	public Customer(String cName,String cUserId,String cPassword,int cNumOfStocks)
	{
		i++;
		this.cName = cName;
		this.cUserId = cUserId;
		this.cPassword = cPassword;
		this.cNumOfStocks = cNumOfStocks;
		this.customerId = customerId;
	}
	
}
