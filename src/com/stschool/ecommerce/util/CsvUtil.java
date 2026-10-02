package com.stschool.ecommerce.util;

import com.stschool.ecommerce.model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {
    public static List<Customer> readCustomersFromCsv() throws IOException {
        //read the data from the csv each line by line
        //first line is headers only so skip this
        //from second line onwards each line represents one customer object
        //read till the end of the file
        List<Customer> customerList = new ArrayList<>();
        File file = new File("D:/java-workspace/customers_csv.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//        System.out.println(bufferedReader.readLine());
        bufferedReader.readLine();
        String customerData = bufferedReader.readLine();
        while (customerData != null) {
            //System.out.println(customerData);
            String[] data = customerData.split(",");
            Customer customer = new Customer();
            customer.setName(data[0]);
            customer.setEmail(data[1]);
            customer.setPhone(data[2]);
            customer.setPhone(data[3]);
            customer.setAge(Byte.parseByte(data[4]));
            customer.setActive(Boolean.parseBoolean(data[5]));
            customer.setMembership(data[6]);
            customerList.add(customer);
            customerData = bufferedReader.readLine();
        }
        return customerList;
    }
}
