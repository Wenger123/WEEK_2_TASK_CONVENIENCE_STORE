package com.francis.implementationTest;
import com.francis.entities.Cashier;
import com.francis.entities.ConvenienceStore;
import com.francis.entities.Product;
import com.francis.services.ENUM.PRODUCT_CATEGORY;
import com.francis.services.ManagerServices;
import com.francis.services.implementation.ManagerImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class ManagerImplementationTest {
    ManagerServices manager = new ManagerImplementation();

    @BeforeEach
    public void setUpHireCashier() {
        manager = new ManagerImplementation();
        /*
         * Assuming you have a cashier map with some entries
         */
        Map<String, Cashier> cashierMap = new HashMap<>();
        cashierMap.put("Rita", new Cashier("Rita", 25, "rita@example.com", 1, "123 Main St", 2000.0));
        ConvenienceStore.setCashierMap(cashierMap);
    }

    @Test
    public void testHireCashier_NewCashier() {
        boolean result = manager.hireCashier("Cynthia", 30, "cynthia@example.com", 2, "456 Elm St", 2200.0);
        assertTrue(result);
    }

    @Test
    public void testHireCashier_ExistingCashier() {
        boolean result = manager.hireCashier("Rita", 25, "rita@example.com", 1, "123 Main St", 2000.0);
        assertFalse(result);
    }

    @BeforeEach
    public void setUpSackCashier() {
        manager = new ManagerImplementation();
        /*
         * Assuming you have a cashier map with some entries
         */
        Map<String, Cashier> cashierMap = new HashMap<>();
        Cashier cashier = new Cashier("Alice", 25, "alice@example.com", 1, "123 Main St", 2000.0);
        cashier.setStrike(3); // Set 2 strikes
        cashierMap.put("Alice", cashier);
        ConvenienceStore.setCashierMap(cashierMap);
    }

    @Test
    public void testSackCashier_ValidName_StrikeLessThan3() {
        boolean result = manager.sackCashier("Alice");
        assertFalse(result); // Strikes less than 3, expect false
    }


    @Test
    public void testSackCashier_InvalidName() {
        boolean result = manager.sackCashier("David");
        assertFalse(result); // Invalid name, expect false
    }

    @BeforeEach
    public void setUp_Remove_Product() {

        manager = new ManagerImplementation();
        /*
         * Assuming you have a product list and product map with some entries
         */
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product("Life", 10, 50, "Red", PRODUCT_CATEGORY.ALCOHOLIC_DRINKS);
        Product product2 = new Product("Bread", 15, 30, "Pink", PRODUCT_CATEGORY.BAKERIES);
        productList.add(product1);
        productList.add(product2);

        Map<String, Product> productMap = new HashMap<>();
        productMap.put("Life", product1);
        productMap.put("Bread", product2);

        ConvenienceStore.setProductList(productList);
        ConvenienceStore.setProductMap(productMap);
    }

    @Test
    public void testRemoveProduct_ExistingProduct() {
        manager.removeProduct("Life");

        // Assuming you have a way to retrieve the product map from ConvenienceStore
        Map<String, Product> productMap = ConvenienceStore.getProductMap();
        assertNull(productMap.get("Life")); // Assert that the product is removed from the map

    }

    @Test
    public void testRemoveProduct_NonExistingProduct() {
        manager.removeProduct("Book");

        // Assuming you have a way to retrieve the product map from ConvenienceStore
        Map<String, Product> productMap = ConvenienceStore.getProductMap();
        assertNull(productMap.get("Book")); // Assert that the product is not in the map

        // Assuming you have a way to retrieve the product list from ConvenienceStore
        List<Product> productList = ConvenienceStore.getProductList();
        assertFalse(productList.isEmpty()); // Assert that the product list is not empty
    }

    @BeforeEach
    public void setUp() {
        manager = new ManagerImplementation();
        // Resetting product list and map to ensure a clean state before each test
        ConvenienceStore.setProductList(new ArrayList<>());
        ConvenienceStore.setProductMap(new HashMap<>());
    }

    @Test
    public void testAddProduct_NewProduct() {
        manager.addProduct("Life", 10, 50, "Red", PRODUCT_CATEGORY.ALCOHOLIC_DRINKS);

        // Assuming you have a way to retrieve the product map from ConvenienceStore
        Map<String, Product> productMap = ConvenienceStore.getProductMap();
        Product addedProduct = productMap.get("Life");

        assertNotNull(addedProduct); // Assert that the product was added
    }
}
