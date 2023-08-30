package com.francis.services.implementation;

import com.francis.entities.Cashier;
import com.francis.entities.Product;
import com.francis.services.ENUM.PRODUCT_CATEGORY;
import com.francis.services.ProductsManagement;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ProductsImplementation implements ProductsManagement {
    private static Map<String,Product> alcoholic_drinks = new HashMap<>();
    private static Map<String,Product> non_Alcoholic_drinks = new HashMap<>();
    private static Map<String,Product> cosmetics = new HashMap<>();
    private static Map<String,Product> beverages = new HashMap<>();
    private static Map<String,Product> bakeries = new HashMap<>();
    private static Map<String,Product> sea_Foods = new HashMap<>();

    public static Map<String, Product> getAlcoholic_drinks() {
        return alcoholic_drinks;
    }

    public static void setAlcoholic_drinks(Map<String, Product> alcoholic_drinks) {
        ProductsImplementation.alcoholic_drinks = alcoholic_drinks;
    }

    public static Map<String, Product> getNon_Alcoholic_drinks() {
        return non_Alcoholic_drinks;
    }

    public static void setNon_Alcoholic_drinks(Map<String, Product> non_Alcoholic_drinks) {
        ProductsImplementation.non_Alcoholic_drinks = non_Alcoholic_drinks;
    }

    public static Map<String, Product> getCosmetics() {
        return cosmetics;
    }

    public static void setCosmetics(Map<String, Product> cosmetics) {
        ProductsImplementation.cosmetics = cosmetics;
    }

    public static Map<String, Product> getBeverages() {
        return beverages;
    }

    public static void setBeverages(Map<String, Product> beverages) {
        ProductsImplementation.beverages = beverages;
    }

    public static Map<String, Product> getBakeries() {
        return bakeries;
    }

    public static void setBakeries(Map<String, Product> bakeries) {
        ProductsImplementation.bakeries = bakeries;
    }

    public static Map<String, Product> getSea_Foods() {
        return sea_Foods;
    }

    public static void setSea_Foods(Map<String, Product> sea_Foods) {
        ProductsImplementation.sea_Foods = sea_Foods;
    }

    @Override
    public boolean addProductsToConvenienceStore() {
        File file = new File("/Users/mac/IdeaProjects/WEEK_2_TASK_CONVENIENCE_STORE/src/main/resources/ProductList.csv");
        String line = " ";
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            while ((line = input.readLine()) != null){
                String[] row = line.split(",");
                if(!row[0].equalsIgnoreCase("name")){
                    if(row[4].equalsIgnoreCase("alcoholic_drinks")){
                        Product newProduct = new Product();
                        newProduct.setProductName(row[0]);
                        newProduct.setPrice(Integer.parseInt(row[1]));
                        newProduct.setQuantity(Integer.parseInt(row[2]));
                        newProduct.setProductColour(row[3]);
                        newProduct.setCategoryName(PRODUCT_CATEGORY.ALCOHOLIC_DRINKS);
                        // Adding created products to the map
                        alcoholic_drinks.put(row[0],newProduct);
                    }
                }
                if(!row[0].equalsIgnoreCase("name")){
                    if(row[4].equalsIgnoreCase("non_Alcoholic_drinks")){
                        Product newProduct = new Product();
                        newProduct.setProductName(row[0]);
                        newProduct.setPrice(Integer.parseInt(row[1]));
                        newProduct.setQuantity(Integer.parseInt(row[2]));
                        newProduct.setProductColour(row[3]);
                        newProduct.setCategoryName(PRODUCT_CATEGORY.NON_ALCOHOLIC_DRINKS);
                        // Adding created products to the map
                        non_Alcoholic_drinks.put(row[0],newProduct);
                    }
                }
                if(!row[0].equalsIgnoreCase("name")){
                    if(row[4].equalsIgnoreCase("cosmetics")){
                        Product product = new Product();
                        product.setProductName(row[0]);
                        product.setPrice(Integer.parseInt(row[1]));
                        product.setQuantity(Integer.parseInt(row[2]));
                        product.setProductColour(row[3]);
                        product.setCategoryName(PRODUCT_CATEGORY.COSMETICS);
                        // Adding created products to the map
                        cosmetics.put(row[0],product);
                    }
                }
                if(!row[0].equalsIgnoreCase("name")){
                    if(row[4].equalsIgnoreCase("beverages")){
                        Product newProduct = new Product();
                        newProduct.setProductName(row[0]);
                        newProduct.setPrice(Integer.parseInt(row[1]));
                        newProduct.setQuantity(Integer.parseInt(row[2]));
                        newProduct.setProductColour(row[3]);
                        newProduct.setCategoryName(PRODUCT_CATEGORY.BEVERAGES);
                        // Adding created products to the map
                        beverages.put(row[0],newProduct);
                    }
                }
                if(!row[0].equalsIgnoreCase("name")){
                    if(row[4].equalsIgnoreCase("bakeries")){
                        Product newProduct = new Product();
                        newProduct.setProductName(row[0]);
                        newProduct.setPrice(Integer.parseInt(row[1]));
                        newProduct.setQuantity(Integer.parseInt(row[2]));
                        newProduct.setProductColour(row[3]);
                        newProduct.setCategoryName(PRODUCT_CATEGORY.BAKERIES);
                        // Adding created products to the map
                        bakeries.put(row[0],newProduct);
                    }
                }
                if(!row[0].equalsIgnoreCase("name")){
                    if(row[4].equalsIgnoreCase("sea_Foods")){
                        Product newProduct = new Product();
                        newProduct.setProductName(row[0]);
                        newProduct.setPrice(Integer.parseInt(row[1]));
                        newProduct.setQuantity(Integer.parseInt(row[2]));
                        newProduct.setProductColour(row[3]);
                        newProduct.setCategoryName(PRODUCT_CATEGORY.SEAFOODS);
                        // Adding created products to the map
                        sea_Foods.put(row[0],newProduct);
                    }
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (IOException e){
            System.out.println("Error occurred " + e);
        }
        return false;
    }

    @Override
    public boolean upDateConvenienceStore() {
        return false;
    }
    public void viewItems(Map<String,Product> productMap){
        System.out.println("Name"+"       "+"Price"+"      "+"Quantity"+"        "+"Colour");
        for(var items : productMap.values()){
            System.out.printf("%-12s %-12s %-12s %-12s", items.getProductName(), items.getPrice(), items.getQuantity(), items.getProductColour());
            System.out.println();
        }
    }


}
