package com.francis.services;

import com.francis.services.ENUM.PRODUCT_CATEGORY;

public interface ManagerServices {
    public boolean hireCashier(String name, int age, String email, int id, String address, double salary);

    public boolean sackCashier(String name);

    public void addProduct(String productName, int price, int quantity, String productColour, PRODUCT_CATEGORY categoryName);

    public void removeProduct(String name);
    public boolean addCashierToConvenienceStore();
}
