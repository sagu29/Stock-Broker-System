package com.masai;
import java.util.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) throws StockNotFoundException, InvalidUserException {
	    // create a list of stocks
		Scanner sc = new Scanner(System.in);
	    List<Stock> stocks = new ArrayList<>();
	    List<Customer> customers = new ArrayList<>();
	    
	    
	    // create a broker object
	    Broker broker = new Broker("admin", "admin123456", customers, stocks);
	    
	    int n;
	    System.out.println("1 - Add to Stock");
	    System.out.println("2 - New customer");
	    System.out.println("3 - log in as a broker");
	    
	    n = sc.nextInt();
	    sc.nextLine();
	    
	    if(n == 1)
	    {
	    	
	    	System.out.println("Enter Stock Name");
	    	String StockName = sc.nextLine();
	    	System.out.println("Enter Quentity of Stock");
	    	int Quentity = sc.nextInt();
	    	System.out.println("Enter pricePerShare");
	    	double pricePerShare = sc.nextDouble();
	    	stocks.add(new Stock(StockName,Quentity,pricePerShare));
	    }
	    else if(n==2)
	    {
	    	
	    	System.out.println("1 - SignUp ");
	    	int a = sc.nextInt();
	    	sc.nextLine();
	    	
	    	
	    	if(a == 1)
	    	{
	    	
	    	System.out.println("Enter your FirstName");
	    	String FirstName = sc.nextLine();
	    	System.out.println("Enter your LastName");
	    	String LastName = sc.nextLine();	    	
	    	String UserName = FirstName +LastName;
	    	System.out.println("Your User Name is " + UserName);
	    	System.out.println("Enter/Create your password");
	    	String password = sc.nextLine();
	    	System.out.println("Enter your address");
	    	String address = sc.nextLine();
	    	System.out.println("Enter your Mobile Number");
	    	String Mobile_Number = sc.nextLine();
	    	System.out.println("Enter your EmailId");
	    	String EmailId = sc.nextLine();
	    	System.out.println("Add the Balance to your wallet");
	    	double walletBalance = sc.nextDouble();
		    customers.add(new Customer(FirstName, LastName, UserName, password, address, Mobile_Number, EmailId, walletBalance));
	    	}
	    	else {
	    		
	    	}
	    	
	    }
	    else if(n==3)
	    {
	    	System.out.println("Enter Username of your Broker");
	    	String Username = sc.nextLine();
	    	String Password = sc.nextLine();
	    	boolean res = broker.login(Username,Password);
	    	if(res == true)
	    	{
	    		System.out.println("Broker has LoggedIn Successfully");
	    		System.out.println("View Customer - 1");
	    		System.out.println("viewStocks - 2");
	    		System.out.println("addStock - 3");
	    		System.out.println("viewStockReport - 4");
	    		int nb = sc.nextInt();
	    		if(nb==1)
	    		{
	    			broker.viewCustomers();
	    		}
	    		else if(nb == 2)
	    		{
	    			 broker.viewStocks();
	    		}
	    		else if(nb == 3)
	    		{
	    			System.out.println("Enter Stock Name");
	    	    	String StockName = sc.nextLine();
	    	    	System.out.println("Enter Quentity of Stock");
	    	    	int Quentity = sc.nextInt();
	    	    	System.out.println("Enter pricePerShare");
	    	    	double pricePerShare = sc.nextDouble();
	    	    	 broker.addStock(new Stock(StockName,Quentity,pricePerShare));
	    		}
	    		else if(nb == 4)
	    		{
	    			broker.viewStockReport("AAPL");
	    		}
	    	}
	    }

	    // buy and sell stocks for a customer
	    Customer customer = customers.get(0);
	    Stock stock = stocks.get(0);
//	    


	    // delete a customer
//	    broker.deleteCustomer(customer);

	    // delete a stock
//	    broker.deleteStock(stock);
	}

}
