package com.francis.services;

import com.francis.services.implementation.CashierImplementation;

public interface CustomerServices {

    public boolean addToCart(String prodName, int quantity);
    public void buyProduct(CashierImplementation cashier);
}
