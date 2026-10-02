package com.stschool.ecommerce.ui;

import com.stschool.ecommerce.controller.CustomerController;
import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.util.Factory;
import com.stschool.ecommerce.util.ScannerUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CustomerUI {
    private final CustomerController customerController;

    public CustomerUI() throws IOException {
        this.customerController = Factory.getCustomerController();
    }

    public CustomerController getCustomerController() {
        return this.customerController;
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

        //controller
        return null;
    }
    public void displayAllCustomers(){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-30s %-15s %-10s %-15s %-10s %-20s\n","NAME","EMAIL","PASSWORD","AGE","PHONE","ACTIVE","MEMBERSHIP");
        System.out.println("-----------------------------------------------------------------------------------------------------------");

        List<Customer> customers = customerController.getCustomers();
        for (Customer customer : customers){
            //System.out.println(customer.getName()+ " " + customer.getEmail() + " " + customer.getPassword() + " " + customer.getPhone() + " " + customer.getAge() + " " + customer.isActive() + " " + customer.getMembership());
            System.out.printf("%-20s %-30s %-15s %-10d %-15s %-10b %-20s\n",customer.getName(), customer.getEmail(), customer.getPassword(), customer.getAge(), customer.getPhone(),customer.isActive(), customer.getMembership());

        }
    }
}