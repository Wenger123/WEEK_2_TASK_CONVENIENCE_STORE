package com.francis.services.implementation;

import com.francis.entities.Customer;
import com.francis.services.CustomerServices;

import java.util.HashMap;
import java.util.Map;

public class CustomerImplementation implements CustomerServices {

    private Customer customer;
    private Map<String, Integer> cart = new HashMap<>();
    public CustomerImplementation(Customer customer) {
        this.customer = customer;
    }


    public Map<String, Integer> getCart() {
        return cart;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCart(Map<String, Integer> cart) {
        this.cart = cart;
    }
    @Override
    public boolean addToCart(String prodName, int quantity) {
        cart.put(prodName, quantity);
        if (cart.containsKey(prodName)) {
            System.out.println("This product " + "\"" + prodName + "\"" + " has been added to customer cart");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void buyProduct(CashierImplementation cashier) {
        System.out.println("This customer "+ "\""+customer.getName()+"\""+" has placed an order");
    }
}
