package com.francis.entities;
import java.util.ArrayList;
import java.util.List;

public class Cashier extends Staff{
    private final String uniform = "Black";
    public int strike = 0;
    public static List<Product> productList = new ArrayList<>();

    public Cashier( String name, int age, String email, int id, String address, double salary) {
        super(name, age, email, id, address, salary);
        this.strike = strike++;
    }

    public Cashier() {
        super();
    }

    public void addToCart(List<Product> products){
        productList.addAll(products);
    }
    public void addStrike() {

        strike++;
    }
    public String getUniform() {

        return uniform;
    }
    public int getStrike() {

        return strike;
    }
    public void setStrike(int strike) {
        this.strike = strike;
    }

    @Override
    public String toString() {
        return "Cashier{" +

                "uniform='" + uniform + '\'' +
                ", strike=" + strike +
                '}';
    }
}
