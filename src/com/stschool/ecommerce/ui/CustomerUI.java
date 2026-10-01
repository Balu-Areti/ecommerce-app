package com.stschool.ecommerce.ui;

import com.stschool.ecommerce.controller.CustomerController;
import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.util.ScannerUtil;

import java.util.Scanner;

public class CustomerUI {
    private static final CustomerUI INSTANCE = new CustomerUI();

    private CustomerUI() {
    }

    public static CustomerUI getInstance() {
        return INSTANCE;
    }

    //Registration form
    public Customer registerForm(){
        Scanner scanner = ScannerUtil.getScanner();
        System.out.println("Please enter your details");
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        System.out.println("Enter your phone number:");
        String phone = scanner.nextLine();
        System.out.println("Enter your age:");
        byte age = scanner.nextByte();
        scanner.nextLine();
        //  Customer customer = new Customer(name, email, password, phone, (byte)age);

        //Data mapping
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setPhone(phone);
        customer.setAge(age);
        System.out.println("Customer Details: " + customer);
        //by default it prints the class name @ hashcode

        //Controller is backend entry gate.
        CustomerController customerController = new CustomerController();
        Customer registeredCustomer = customerController.register(customer);
        System.out.println("Registered Customer Details: " + registeredCustomer );

        return customer;
    }

    public Customer loginForm(){
        System.out.println("Login Form");
        Scanner scanner = ScannerUtil.getScanner();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        ScannerUtil.closeScanner();
        //controller
        return null;
    }
}