package com.francis.entities;

import com.francis.services.ENUM.PRODUCT_CATEGORY;

public class Product {
    private String productName;
    private int price;
    private int quantity;
    private String productColour;
    private PRODUCT_CATEGORY categoryName;

    public Product(String productName, int price, int quantity, String productColour, PRODUCT_CATEGORY categoryName) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productColour = productColour;
        this.categoryName = categoryName;
    }
    public Product(){

    }
    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductColour() {
        return productColour;
    }

    public void setProductColour(String productColour) {
        this.productColour = productColour;
    }

    public PRODUCT_CATEGORY getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(PRODUCT_CATEGORY categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", productColour='" + productColour + '\'' +
                ", categoryName=" + categoryName +
                '}';
    }
}

