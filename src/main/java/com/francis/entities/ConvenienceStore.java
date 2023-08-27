package com.francis.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ConvenienceStore {
    public String name;
    public String address;
    private String email;
    public static List<Cashier>  cashierList = new ArrayList<>();
    public static Map <String, Cashier> cashierMap = new TreeMap<>();
    public static List <Product> productList = new ArrayList<>();
    public static Map <String,Product> productMap = new TreeMap<>();

    public ConvenienceStore(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }
    public static void addCashier(Cashier cashier){
        cashierList.add(cashier);
    }
    public static void addToCashierMap(String name, Cashier cashier){
        cashierMap.put(name,cashier);
    }
    public static void addProduct(Product product){
        productList.add(product);
    }
    public static void addToProductMap(String name, Product product){
        productMap.put(name,product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<Cashier> getCashierList() {
        return cashierList;
    }
    public static List<Product> getProductList() {
        return productList;
    }

    public static void setProductList(List<Product> productList) {
        ConvenienceStore.productList = productList;
    }

    public static Map<String, Cashier> getCashierMap() {
        return cashierMap;
    }

    public static void setCashierMap(Map<String, Cashier> cashierMap) {
        ConvenienceStore.cashierMap = cashierMap;
    }

    public static Map<String, Product> getProductMap() {
        return productMap;
    }

    public static void setProductMap(Map<String, Product> productMap) {
        ConvenienceStore.productMap = productMap;
    }
}

