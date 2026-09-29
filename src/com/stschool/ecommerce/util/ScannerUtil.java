package com.stschool.ecommerce.util;

import java.util.Scanner;

public class ScannerUtil {
    //singleton Scanner Object

    private static Scanner scanner = null;

    public static Scanner getScanner(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
    public static void closeScanner(){
        scanner.close();
    }

}