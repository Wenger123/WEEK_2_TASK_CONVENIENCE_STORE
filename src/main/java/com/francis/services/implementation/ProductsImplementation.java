package com.francis.services.implementation;

import com.francis.services.ProductsManagement;

import java.io.File;

public class ProductsImplementation implements ProductsManagement {
    @Override
    public boolean addProductsToConvenienceStore() {
        File csvFile = new File("/Users/mac/IdeaProjects/WEEK_2_TASK_CONVENIENCE_STORE/src/main/resources/ProductList.csv");
        String csv = " ";
        try {

        } catch (Exception e) {
            System.out.println("error " + e);
        }


        return true;
    }

    @Override
    public boolean upDateConvenienceStore() {
        return false;
    }
}
