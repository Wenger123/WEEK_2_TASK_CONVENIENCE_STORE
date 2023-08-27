package com.francis.services.implementation;

import com.francis.entities.Cashier;
import com.francis.entities.ConvenienceStore;
import com.francis.entities.Product;
import com.francis.services.ENUM.PRODUCT_CATEGORY;
import com.francis.services.ManagerServices;

import java.util.Map;

import static com.francis.entities.ConvenienceStore.*;

public class ManagerImplementation implements ManagerServices {

    @Override
    public boolean hireCashier(String name, int age, String email, int id, String address, double salary) {
        Cashier newCashier = new Cashier(name, age, email, id, address, salary);
        Map<String, Cashier> cashierMap1 = ConvenienceStore.getCashierMap();
        if(!cashierMap1.containsKey(name)) {
            ConvenienceStore.addCashier(newCashier);
            ConvenienceStore.addToCashierMap(name, newCashier);
            System.out.println(name.toLowerCase() + " has been hired as a cashier.");
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean sackCashier(String name) {
        Cashier cashierName = cashierMap.get(name);
        Map<String, Cashier> cashierMap1 = ConvenienceStore.getCashierMap();
        if(cashierMap1.containsKey(name)) {
            if (cashierName != null) {
                cashierName.addStrike();
                System.out.println(name + " you have been given a strike: " + cashierName.getStrike() + " strikes");
                if (cashierName.getStrike() >= 3) {
                    cashierList.remove(cashierName);
                    cashierMap.remove(name);
                    System.out.println(name + " You cashier has been sacked due to number of strikes is greater than 3.");
                }
            } else
                System.out.println("Name not on our list or map");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void addProduct(String productName, int price, int quantity, String productColour, PRODUCT_CATEGORY categoryName) {
        Product newProduct = new Product(productName,price,quantity,productColour,categoryName);
        ConvenienceStore.addProduct(newProduct);
        ConvenienceStore.addToProductMap(productName,newProduct);
        System.out.println("This product "+ "\""+productName+"\"" + " has been added to the product list");

    }

    @Override
    public void removeProduct(String name) {
        Product productBought = null;
        for (Product product : productList){
            if (product.getProductName().equals(name) ){
                productBought = product;
                break;
            }
        }
        if (productBought != null){
            productList.remove(productBought);
            productMap.remove(name);
            System.out.println(name + " Has been removed from our product list");
        }
        else
            System.out.println("Product not found in our product list");

    }
}

