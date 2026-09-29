package com.stschool.ecommerce.controller;

import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.service.CustomerService;

public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(){
        this.customerService = new CustomerService();
    }

    public Customer register(Customer customer){
        System.out.println("Customer Controller Register Method called");
        System.out.println("Customer Details: " + customer  );
        //service layer

        Customer registedCustomer =  customerService.register(customer);
        System.out.println("Customer Registered Successfully");
        return registedCustomer;
    }
}