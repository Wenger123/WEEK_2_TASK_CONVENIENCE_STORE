package com.francis.implementationTest;

import com.francis.entities.Customer;
import com.francis.services.implementation.CashierImplementation;
import com.francis.services.implementation.CustomerImplementation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerImplementationTest {

    @Test
    public void testAddToCart() {
        Customer customer = new Customer("Frank", "08131087884", 100_000.0); // Assuming constructor

        CustomerImplementation customerServices = new CustomerImplementation(customer);
        boolean result = customerServices.addToCart("Coke", 2);

        assertTrue(result);
        assertEquals(2, customerServices.getCart().get("Coke"));
    }

    @Test
    public void testBuyProduct() {
        Customer customer = new Customer("Frank", "08131087884", 100.0); // Assuming constructor
        CashierImplementation cashierServices = new CashierImplementation(); // Assuming constructor

        CustomerImplementation customerServices = new CustomerImplementation(customer);
        customerServices.buyProduct(cashierServices);
        // Assuming you want to verify a certain message or behavior after buying a product
    }
}
