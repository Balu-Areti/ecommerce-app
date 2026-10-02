package com.stschool.ecommerce.util;

import com.stschool.ecommerce.controller.CustomerController;
import com.stschool.ecommerce.repository.CustomerRepository;
import com.stschool.ecommerce.service.CustomerService;
import com.stschool.ecommerce.ui.CustomerUI;

import java.io.IOException;

public class Factory {
    private static CustomerController customerController;
    private static CustomerService customerService;
    private static CustomerRepository customerRepository;

    public static CustomerController getCustomerController() throws IOException {
        if (customerController == null) {
            customerController = new CustomerController(getCustomerService());
        }return customerController;
    }
    public static CustomerService getCustomerService() throws IOException {
        if (customerService == null) {
            customerService = new CustomerService(getCustomerRepository());
        }return customerService;
    }
    public static CustomerRepository getCustomerRepository() throws IOException {
        if (customerRepository == null) {
            customerRepository = new CustomerRepository();
        }return customerRepository;
    }
}
