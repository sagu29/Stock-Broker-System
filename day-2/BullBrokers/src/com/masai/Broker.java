package com.masai;

import java.util.List;
import java.util.ArrayList;
public class Broker implements User {
	
	    private final String username;
	    private final String password;
	    private List<Customer> customers;
	    private List<Stock> stocks;
		private Transaction[] transactions;

	public Broker()
	{
		  this.username = "admin";
		  this.password = "admin";
		  customers = new ArrayList<>();
	      stocks = new ArrayList<>();
	}
	
	public Broker(String username, String password, List<Customer> customers, List<Stock> stocks) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		this.customers = customers;
		this.stocks = stocks;
		
	}

	public boolean login(String username, String password) throws InvalidUserException {
	        if (this.username.equals(username) && this.password.equals(password)) {
	            return true;
	        } else {
	            throw new InvalidUserException("Invalid username or password");
	        }
	 }
	 public void signup(String firstName, String lastName, String username, String password,String address, String mobileNumber, String email) throws InvalidUserException {
       for (Customer c : customers)
       {
           if (c.getEmail().equals(email))
           {
               throw new InvalidUserException("Email already exists");
           }
      }
       
      double walletBalance = 500.00;
	Customer newCustomer = new Customer( firstName,  lastName,  username,  password,  address,  mobileNumber,  email,  walletBalance);
     customers.add(newCustomer);
}
   
	 public void addStock(String name, int quantity, double price) {
	        for (Stock s : stocks) {
	            if (s.getName().equals(name)) {
	                s.setQuantity(s.getQuantity() + quantity);
	                return;
	            }
	        }
	        Stock newStock = new Stock(name, quantity, price);
	        stocks.add(newStock);
	    }
	 
	    public void deleteStock(String name) throws InvalidStockException {
	        Stock stockToDelete = null;
	        for (Stock s : stocks) {
	            if (s.getName().equals(name)) {
	                stockToDelete = s;
	                break;
	            }
	        }
	        if (stockToDelete == null) {
	            throw new InvalidStockException("Invalid stock name");
	        }
	        for (Customer c : customers) {
	            double amount = c.sellStock(name, stockToDelete.getPricePerShare());
	            if (amount > 0) {
	                c.credit(amount);
	            }
	        }
	        stocks.remove(stockToDelete);
	    }
	    // Delete customer method
	    public void deleteCustomer(Customer c) {
	        double amount = c.getTotalAmount();
	        c.setActive(false);
	        for (Stock s : stocks) {
	            int quantity = (int) c.sellStock(s.getName(), s.getPricePerShare());
	            s.setQuantity(s.getQuantity() + quantity);
	        }
	        c.credit(amount);
	    }

	    // View all customers method
	    public void viewCustomers() {
	        System.out.println("List of customers:");
	        for (Customer c : customers) {
	            System.out.println(c.toString());
	        }
	    }

	    // View all stocks method
	    public void viewStocks() {
	        System.out.println("List of stocks:");
	        for (Stock s : stocks) {
	            System.out.println(s.toString());
	        }
	    }

	    // View consolidated report of a stock method
//	    public void viewStockReport(String name) throws InvalidStockException
//
//	 
//	
//         }

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isActive() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setActive(boolean active) {
			// TODO Auto-generated method stub
			
		}

		public void addStock(Stock stock) {
			// TODO Auto-generated method stub
			addStock(stock. getName(), stock.getQuantity(), stock. getPricePerShare());
			
		}

		public Stock findStock(String stockName) throws StockNotFoundException {
		    // Iterate through the list of stocks and return the first one with a matching name
		    for (Stock stock : stocks) {
		        if (stock.getName().equals(stockName)) {
		            return stock;
		        }
		    }

		    // If no matching stock was found, throw a custom exception
		    throw new StockNotFoundException("Stock not found: " + stockName);
		}
		
		public void viewStockReport(String stockName) throws StockNotFoundException {
		    Stock stock = findStock(stockName);
		    if (stock == null) {
		        System.out.println("Stock not found!");
		        return;
		    }
		    int totalPiecesSold = 0;
			for (Transaction t : transactions) {
		        if (t.getStockName().equals(stockName) && t.getTransactionType() == TransactionType.SELL) {
		            totalPiecesSold += t.getQuantity();
		        }
		    }

		    int piecesYetToBeSold = stock.getQuantity() - totalPiecesSold;

		    System.out.println("Stock report for " + stockName + ":");
		    System.out.println("Total pieces sold: " + totalPiecesSold);
		    System.out.println("Pieces yet to be sold: " + piecesYetToBeSold);
		}

//		public void viewStockReport(String stockName) {
//			// TODO Auto-generated method stub
//			
//		}


	
}
