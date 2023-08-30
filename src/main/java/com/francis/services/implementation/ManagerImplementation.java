package com.francis.services.implementation;

import com.francis.entities.Cashier;
import com.francis.entities.ConvenienceStore;
import com.francis.entities.Product;
import com.francis.services.ENUM.PRODUCT_CATEGORY;
import com.francis.services.ManagerServices;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static com.francis.entities.ConvenienceStore.*;

public class ManagerImplementation implements ManagerServices {
    private static Map<String, Cashier> cashiers = new HashMap<>();



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
    @Override
    public boolean addCashierToConvenienceStore() {
        File file = new File("/Users/mac/IdeaProjects/WEEK_2_TASK_CONVENIENCE_STORE/src/main/resources/CashierList.csv");
        String line = " ";
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(file));
            while ((line = myReader.readLine()) !=null){
                String[] row = line.split(",");
                if (!row[0].equalsIgnoreCase("name")){
                    if(!row[0].equalsIgnoreCase("cashiers")){
                        Cashier cashier = new Cashier();
                         cashier.setName(row[0]);
                         cashier.setAge(Integer.parseInt(row[1]));
                         cashier.setEmail(row[2]);
                         cashier.setId(Integer.parseInt(row[3]));
                         cashier.setAddress(row[4]);
                         cashier.setSalary(Integer.parseInt(row[5]));
                         cashier.setStrike(Integer.parseInt(row[7]));

                        cashiers.put(cashier.getName(), cashier);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found "+ e);
        } catch (IOException e) {
            System.out.println("error occurred "+ e);
        }
        return false;
    }

    public static Map<String, Cashier> getCashiers() {
        return cashiers;
    }

    public static void setCashiers(Map<String, Cashier> cashiers) {
        ManagerImplementation.cashiers = cashiers;
    }

    public void viewCashierList() {
        System.out.println("Name" + "           " + "Age" + "           " + "Email" + "           " + "Id"+"             "+"Address" + "           " + "Salary" + "            " + "Uniform" + "            " + "Strike");
        for (var items : getCashiers().values()) {
            System.out.printf("%-15s %-8s %-19s %-13s %-19s %-17s %-19s %-12s", items.getName(), items.getAge(), items.getEmail(), items.getId(),items.getAddress(),items.getSalary(),items.getUniform(),items.getStrike());
            System.out.println();
        }
    }
}

