package com.masai;

public class StockNotFoundException extends Exception {
    public StockNotFoundException(String message) {
        super(message);
    }
}
