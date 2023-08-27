package com.francis.implementationTest;

import com.francis.entities.Cashier;
import com.francis.entities.ConvenienceStore;
import com.francis.entities.Customer;
import com.francis.entities.Product;
import com.francis.services.ENUM.PRODUCT_CATEGORY;
import com.francis.services.implementation.CashierImplementation;
import com.francis.services.implementation.CustomerImplementation;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CashierImplementationTest {

    @Test
    public void testDispensesReceipts() {
        ConvenienceStore.getProductMap().put("Coke", new Product("Coke",7000,30,"Blue", PRODUCT_CATEGORY.NON_ALCOHOLIC_DRINKS));
        ConvenienceStore.getProductMap().put("Life", new Product("Life",500,50,"Green", PRODUCT_CATEGORY.ALCOHOLIC_DRINKS));

        Customer customer = new Customer("Mr paul", "1234567890", 50_000.0);
        CustomerImplementation customerServices = new CustomerImplementation(customer);


        customerServices.setCustomer(customer);

        Map<String, Integer> cart = new HashMap<>();
        cart.put("Coke", 2);
        cart.put("Life", 3);
        customerServices.setCart(cart);

        Cashier cashier = new Cashier("Rita",35,"rita@gmail.com",2,"Kubwa Abuja",50_000);

        CashierImplementation cashierServices = new CashierImplementation();

        boolean result = cashierServices.dispensesReceipts(customerServices, cashier);

        assertTrue(result); // The customer has enough balance

        ConvenienceStore.getProductMap().clear();
    }
}
