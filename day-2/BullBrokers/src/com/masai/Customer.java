package com.masai;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String mobileNumber;
    private String email;
    private double walletBalance;
    private List<Transaction> transactionHistory;
    private boolean isActive;

    public Customer(String firstName, String lastName, String username, String password, String address, String mobileNumber, String email, double walletBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.walletBalance = walletBalance;
        this.transactionHistory = new ArrayList<>();
        this.isActive = true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionHistory.add(transaction);
    }

    public void setActive(boolean active) {
        isActive = active;
    }

	public double getTotalAmount() {
		// TODO Auto-generated method stub
		return walletBalance;
	}

	public double sellStock(String name, double pricePerShare) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deductFromWallet(double totalPrice) {
		// TODO Auto-generated method stub
		if (this.walletBalance < totalPrice) {
	        throw new IllegalArgumentException("Insufficient funds");
	    }
	    this.walletBalance -= totalPrice;
		
	}
	public void credit(double amount) {
	    this.walletBalance += amount;
	}

}
