package com.tcs.example.shoppingcart.exception;

public class ShoppingCartEmptyException extends Exception {


    public ShoppingCartEmptyException(String errorMessage) {
        super(errorMessage);
    }
}
