package com.masai;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
public class Main {
static ArrayList<Customer> customers = new ArrayList<>();

    public static void runProgram(Scanner sc)
    {
    	System.out.println("Press 1 to Login as Broker/Admin");
		System.out.println("Press 2 to Login as Customer");
		System.out.println("Press 3 to Sign Up/Create New Account");
		
		int option = sc.nextInt();
		if(option == 1)
		{
			sc.nextLine();
			LoginAsBroker(sc);
		}
		else if(option == 2) {
			sc.nextLine();
			LoginAsCustomer(sc);
		}
		else if(option == 3)
		{
			sc.nextLine();
			CreateNewAccount(sc);
		}
    }

	private static void CreateNewAccount(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter your Name");
		String name = sc.nextLine();
		System.out.println("Create your UserId/Enter Email");
		String UserId = sc.nextLine();
		System.out.println("Create your Password");
		String Password = sc.nextLine();
		
		for(Customer i : customers)
		{
			if(i.cUserId.equals(UserId))
			{
				System.out.println("Customer is already present, Please Try with another Userid");
				return;
			}
		}
		Customer c1 = new Customer(name,UserId,Password,0);
		customers.add(c1);
		System.out.println("SignUp Sucessfully");
		
		runProgram(sc);
	}
	private static void LoginAsCustomer(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter your User Name/UserId/Enter Email");
		String userName = sc.nextLine();
		System.out.println("Enter your Password");
		String pass = sc.nextLine();
		
		int cheack =0;
		
		for(Customer i : customers)
		{
			if(i.cUserId.equals(userName) && i.cPassword.equals(pass))
			{
				cheack ++;
				System.out.println("Loged in Successfully");
				LoginSuccessfully(i,sc);
			}
		}
		if(cheack == 0 )
		{
			System.out.println("Incorrect UserId or Password");
		}
		
	}

	private static void LoginSuccessfully(Customer i, Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Custumer Details");
		
		System.out.println(i.customerId+" "+i.cName);
		
		if(i.cS != null)
		{
			for(Stock j : i.cS)
			{
				System.out.println(j.stockName+" "+ j.stockPrice);
			}
		}
		else {
			System.out.println("Please Purchase Stock");
		}
		System.out.println("press 1 to Purchase New Stock");
		System.out.println("press 2 to Sell Stock");
		System.out.println("press 3 to LogOut");
		
		int Cusin = sc.nextInt();
		
		if(Cusin == 1)
		{
			Broker b = new Broker();
			
			for(Stock j : Broker.s )
			{
				System.out.println(j.stockId+" "+j.stockName+" "+j.stockPrice);
			}
			
			System.out.println("Enter the Stock id");
			System.out.println("press 0 for main Manu");
			
			int si = sc.nextInt();
			if(si == 0)
			{
				LoginSuccessfully(i,sc);
			}
			else {
			int c = 0;
			for(Stock j : i.cS)
			{
				if(j.stockId == si)
				{
					c++;
				}
			}
			if(c == 0)
			{
				System.out.println("Stock is Allready Purchased");
			}
			else 
			{
//				Stock newS = null;
				for(Stock j : Broker.s )
				{
					
					if(j.stockId == si)
					{
						
						i.cS.add(j);
						System.out.println("Stock is Purchased");
					}
				}
			}
			LoginSuccessfully(i,sc);
			}
		}
		else if(Cusin == 2)
		{
//			for(Stock s : i.cS)
//			{
//				System.out.println(st.stockId+" "+st.stockName+" "+st.stockPrice);
//			}
			for(Stock st : i.cS)
			{
				System.out.println(st.stockId+" "+st.stockName+" "+st.stockPrice);
			}
			System.out.println("Enter the Stock Id for Sell");
			System.out.println("press 0 for main Manu");
			
			int sellid = sc.nextInt();
			
			if(sellid == 0 )
			{
				LoginSuccessfully(i,sc);
			}
			else {
				System.out.println("Stock is Selled");
				
				for(Stock j : i.cS)
				{
					if(j.stockId == sellid)
					{
						i.cS.remove(j);
						System.out.println("Stock is Selled");
					}
				}
			}
			LoginSuccessfully(i,sc);
		}
		else if(Cusin == 3)
		{
			runProgram(sc);
		}
	}

	private static void LoginAsBroker(Scanner sc) {
		// TODO Auto-generated method stub
	    
		System.out.println("Enter your User Name");
		String userName = sc.nextLine();
		System.out.println("Enter your Password");
		String pass = sc.nextLine();
		
		Broker B1 = new Broker();
		boolean res = B1.checkCredential(userName, pass);
		if(res == true)
		{
			System.out.println("Broker/Admin is Login Succsfully");
			BrokerLoginSucces(B1,sc);
		}
		else {
			System.out.println("Please Enter Correct UserId or Password");
	    }
	}
	private static void BrokerLoginSucces(Broker B1,Scanner sc) 
	{
		// TODO Auto-generated method stub
		System.out.println("press 1 for showStockList");
		System.out.println("press 2 for showCustomerList");
		System.out.println("press 3 for Log Out");
		int bchoice = sc.nextInt();
		if(bchoice == 1)
		{
			showStockList(B1,sc);
		}
		else if(bchoice == 2)
		{
			ShowBrokerCusList(B1,sc);
		}
		else if(bchoice == 3)
		{
			runProgram(sc);
		}
		
	}

	private static void ShowBrokerCusList(Broker B1, Scanner sc) {
		// TODO Auto-generated method stub
		
		B1.showCustomerList();
		System.out.println("press 1 for Delete Customer");
		System.out.println("press 0 for Enter 0 for All Options");
		int Dcus = sc.nextInt();
		if(Dcus == 1)
		{
			System.out.println("Enter Customer Id to Delete Customer");
			int CusId = sc.nextInt();
			B1.deleteCustomer(CusId);
		}
		else {
			BrokerLoginSucces(B1,sc);
		}
		
		
	}

	private static void showStockList(Broker B1, Scanner sc) {
		// TODO Auto-generated method stub
		B1.showStockList();
		
		System.out.println("press 1 for Add Stock");
		System.out.println("press 2 for Delete Stock");
		System.out.println("press 3 for  All Options");
		
		int A_D_stock = sc.nextInt();
		
		if(A_D_stock == 1)
		{
			System.out.println("Enter the StockId");
			int stockId = sc.nextInt();
			sc.nextLine();
			System.out.println("Please enter Stock Name to Add into your Stock");
			String stockName = sc.nextLine();
			System.out.println("Please enter Stock Price");
			double StockPrice = sc.nextDouble();
			B1.addStock(stockId,stockName, StockPrice);
		}
		else if(A_D_stock == 2)
		{
			System.out.println("Enter StockId to delete Stock");
			int stockId = sc.nextInt();
			B1.deleteStock(stockId);
		}
		else if(A_D_stock == 3)
		{
			BrokerLoginSucces(B1,sc);
		}
		
		System.out.println("Enter 0 for All Options");
		int op = sc.nextInt();
		if(op == 0)
		{
			BrokerLoginSucces(B1,sc);
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		customers.add(new Customer("Sagar","s@gmail.com","123",0));
		customers.add(new Customer("yogesh","y@gmail.com","123",0));
		runProgram(sc);
	}

}
