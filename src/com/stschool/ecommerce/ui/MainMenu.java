package com.stschool.ecommerce.ui;

import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.util.ScannerUtil;

import java.util.Scanner;

public class MainMenu {

    private static final CustomerUI customerUI = CustomerUI.getInstance();

    public static void mainMenu() {
        System.out.println("Welcome to EBuy App");
        System.out.println("--------------------");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("--------------------");
        System.out.println("Enter your choice:");

        Scanner scanner = ScannerUtil.getScanner();
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear leftover newline

        switch (choice) {
            case 1:
                //Singleton through dependencies
                Customer customerUi = customerUI.registerForm();
                break;

            case 2:
                System.out.println("Login Form");
                Customer customer = customerUI.loginForm();
                break;

            case 3:
                System.out.println("Exiting the application");
                System.exit(0);
                break;
        }
    }
}