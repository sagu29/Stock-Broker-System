package com.masai;

import java.time.LocalDateTime;

 enum TransactionType {
    BUY,
    SELL
}


public class Transaction {
	
	
    private LocalDateTime timestamp;
    private String type;
    private String stockName;
    private int quantity;
    private double pricePerShare;
	private double totalPrice;

//    public Transaction(Type type, String stockName, int quantity, double pricePerShare) {
//        this.timestamp = LocalDateTime.now();
//        this.type = type;
//        this.stockName = stockName;
//        this.quantity = quantity;
//        this.pricePerShare = pricePerShare;
//    }
    public Transaction(String type, String stockName, int quantity, double totalPrice) {
        this.type = type;
        this.stockName = stockName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.timestamp = LocalDateTime.now();
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public String getStockName() {
        return stockName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    public double getTotalCost() {
        return quantity * pricePerShare;
    }
    
//    public String getTransactionType() {
//        if (quantity > 0) {
//            return "Buy";
//        } else {
//            return "Sell";
//        }
//    }
    public TransactionType getTransactionType() {
        if (quantity > 0) {
            return TransactionType.BUY;
        } else {
            return TransactionType.SELL;
        }
    }

    
}
