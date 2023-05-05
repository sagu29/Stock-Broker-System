package com.masai;
import java.util.ArrayList;
import java.util.List;
public class Broker {
	String userId = "admin";
	String password = "admin";
	static List<Stock> s =  new ArrayList<>(); ;
	
	public Broker() {
		
	}
	
	public boolean checkCredential(String userId, String password){
		
		if(this.userId.equals(userId) && this.password.equals(password))
		{
			
			return true;
		}
		else {
			return false;
		}
	}
	public void showStockList() {
		
		for(Stock i : s)
		{
			System.out.println(i.stockName+" "+i.stockPrice);
		}
	}
	public void showCustomerList() {
		for(Customer i : Main.customers)
		{
			System.out.println(i.cName+" "+i.cNumOfStocks);
		}
	}
	public void addStock(int stockId,String stockName, double stockPrice) 
	{
		for(Stock i : s)
		{
			if(i.stockId == stockId)
			{
				i.stockName = stockName;
				i.stockPrice = stockPrice;
				System.out.println("Stock is Allready Present in list only price is changed");
				return;
			}
		}
		Stock s1 = new Stock(stockId,stockName,stockPrice);
		s.add(s1);
		System.out.println("Stock is added to Stock List");
	}
	public void deleteStock(int stockId)
	{
		for(Stock i : s)
		{
			if(i.stockId == stockId)
			{
				System.out.println(i.stockId+" "+ i.stockName+" "+ i.stockPrice);
				s.remove(i);
				System.out.println("Stock Deleted Successfully");
				return;
			}
		}
		System.out.println("Stock is not Present in Stock List");
	}
	public void deleteCustomer(int customerId)
	{
		for(Customer i : Main.customers)
		{
			if(i.customerId == customerId)
			{
				System.out.println(i.customerId+" "+i.cName);
				Main.customers.remove(i);
				System.out.println("customer Deleted Successfully");
				return;
			}
		}
		System.out.println("customer is not Present in customer List");
	}
}
