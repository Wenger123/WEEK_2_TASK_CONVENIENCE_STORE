package com.francis.entities;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String phoneNumber;
    private double wallet;
    public List <Product> cart;

    public Customer(String name, String phoneNumber, double wallet) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.wallet = wallet;
        cart = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(Product cart) {
        this.cart.add(cart);
    }
}

