package com.stschool.ecommerce.ui;

import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.util.ScannerUtil;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {

    private static final CustomerUI customerUI;

    static {
        try {
            customerUI = new CustomerUI();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mainMenu() {

        boolean continueShopping = true;
        while (continueShopping) {
            System.out.println("Welcome to EBuy App");
            System.out.println("--------------------");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. CustomerList");
            System.out.println("4. Exit");
            System.out.println("--------------------");
            System.out.println("Enter your choice:");

            Scanner scanner = ScannerUtil.getScanner();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear leftover newline

            switch (choice) {
                case 1:
                    try {
                        //Singleton through dependencies
                        Customer customerUi = customerUI.registerForm();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Login Form");
                    Customer customerUi = customerUI.loginForm();
                    break;
                case 3:
                    customerUI.displayAllCustomers();
                    break;

                case 4:
                    System.out.println("Exiting the application");
                    System.exit(0);
                    break;

            }
            System.out.println("Do you wish to contine Shopping(true/false)");
            continueShopping = scanner.nextBoolean();

        }
    }
}