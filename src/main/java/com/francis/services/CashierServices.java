package com.francis.services;

import com.francis.entities.Cashier;
import com.francis.services.implementation.CustomerImplementation;

public interface CashierServices {
    boolean dispensesReceipts(CustomerImplementation customer, Cashier cashier);
}
