package com.masai;
public class Stock {
    private String name;
    private int quantity;
    private double pricePerShare;

    public Stock(String name, int quantity, double pricePerShare) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerShare = pricePerShare;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int sellStock(int quantity, Customer customer) throws IllegalArgumentException {
        if (quantity < 1 || quantity > this.quantity) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        double totalPrice = quantity * this.pricePerShare;
        if (customer.getWalletBalance() < totalPrice) 
        {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.quantity -= quantity;
        customer.deductFromWallet(totalPrice);
        customer.addTransaction(new Transaction("Sell", this.name, quantity, totalPrice));
        return this.quantity;
    }

}
