package com.masai;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main {
static ArrayList<Customer> customers = new ArrayList<>();

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 to Login as Broker/Admin");
		System.out.println("Press 2 to Login as Customer");
		System.out.println("Press 3 to Sign Up/Create New Account");
		int option = sc.nextInt();
		sc.nextLine();
		if(option == 1)
		{
			System.out.println("Enter your User Name");
			String userName = sc.nextLine();
			System.out.println("Enter your Password");
			String pass = sc.nextLine();
			
			Broker B1 = new Broker();
			boolean res = B1.checkCredential(userName, pass);
			if(res == true)
			{
				System.out.println("Broker/Admin Login Succsfully");
				
				System.out.println("Press 1 to showStockList");
				System.out.println("Press 2 to showCustomerList");
				System.out.println("Press 3 to Delete Customer");
				
				int bchoice = sc.nextInt();
				//sc.nextLine();
				if(bchoice == 1)
				{
					B1.showStockList();
					
					System.out.println("Press 1 to Add Stock");
					System.out.println("Press 2 to Delete Stock");
					
					int A_D_stock = sc.nextInt();
					
					if(A_D_stock == 1)
					{
						System.out.println("Enter StockId");
						int stockId = sc.nextInt();
						sc.nextLine();
						System.out.println("Please enter Stock_Name for Adding into Stock List");
						String stockName = sc.nextLine();
						System.out.println("Please enter Market Stock_Price");
						double StockPrice = sc.nextDouble();
						B1.addStock(stockId,stockName, StockPrice);
					}
					else if(A_D_stock == 2)
					{
						System.out.println("Enter StockId for delete Stock");
						int stockId = sc.nextInt();
						B1.deleteStock(stockId);
					}
					
				}
				else if(bchoice == 2)
				{
					B1.showCustomerList();
					
					System.out.println("Press 1 to Delete Customer");
					System.out.println("Press 0 to Exit");
					int Dcus = sc.nextInt();
					
					if(Dcus == 1)
					{
						System.out.println("Enter Customer Id to Delete Customer from list");
						int CusId = sc.nextInt();
						B1.deleteCustomer(CusId);
					}
					else {
						System.out.println("Exit Successfully");
					    return;
					}
					
				}
				
			}
			else {
				System.out.println("Please Enter valid Login Credential");
			}
		}
		else if(option == 2)
		{
			System.out.println("Enter User Name/Enter Email");
			String userName = sc.nextLine();
			System.out.println("Enter Password");
			String pass = sc.nextLine();
			int cheack =0;
			for(Customer i : customers)
			{
				if(i.cUserId.equals(userName) && i.cPassword.equals(pass))
				{
					cheack ++;
					System.out.println("Login Successfully");
					System.out.println("Custumer Details");
					System.out.println(i.customerId+" "+i.cName);
					for(Stock j : i.cS)
					{
						System.out.println(j.stockName+" "+ j.stockPrice);
					}
					System.out.println("Press 1 to Purchase New Stock");
					System.out.println("Press 2 to Sell Stock");
					System.out.println("Press 3 to Exit");
					
					int Cusin = sc.nextInt();
					
					if(Cusin == 1)
					{
						for(Stock j : Broker.s )
						{
							System.out.println(j.stockId+" "+j.stockName+" "+j.stockPrice);
						}
						System.out.println("Enter the Stock id");
						int si = sc.nextInt();
						int c =0;
						for(Stock j : i.cS)
						{
							if(j.stockId == si)
							{
								c++;
							}
						}
						if(c ==0)
						{
							System.out.println("Stock Allready Purchased");
						}
						else {
							Stock newS = null;
							for(Stock j : Broker.s )
							{
								if(j.stockId == si)
								{
									newS = j;
								}
							}
							i.cS.add(newS);
						}
						
						
					}
					else if(Cusin == 2)
					{
						System.out.println("Enter Stock Id to Sell");
						int sellid = sc.nextInt();
						
						
						for(Stock j : i.cS)
						{
							if(j.stockId == sellid)
							{
								i.cS.remove(j);
								System.out.println("Stock is Sell");
							}
						}
					}
				}
			}
			if(cheack == 0)
			{
				System.out.println("Please Enter Valid Username or Password");
			}
			return;
		}
		else if(option == 3)
		{
			System.out.println("Enter Name");
			String name = sc.nextLine();
			System.out.println("Create UserId/Enter Email");
			String UserId = sc.nextLine();
			System.out.println("Create Password");
			String Password = sc.nextLine();
			
			for(Customer i : customers)
			{
				if(i.cUserId.equals(UserId))
				{
					System.out.println("Customer Allready Exsist, Please Try with another Userid");
					return;
				}
			}
			Customer c1 = new Customer(name,UserId,Password,0);
			customers.add(c1);
			System.out.println("Successfull SignUp");
			
		}
	}
}
