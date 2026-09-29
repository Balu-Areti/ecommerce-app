package com.stschool.ecommerce.service;

import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.repository.CustomerRepository;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(){
        this.customerRepository = new CustomerRepository();
    }

    public Customer register(Customer customer){
        System.out.println("Customer Service Register Method called");
        //check whether customer already exists or not

        Customer customerByEmail = customerRepository.findByEmail(customer.getEmail());
        if(customerByEmail != null){
            System.out.println("Customer already exists");
            return null;
        }

        System.out.println("Customer Details: " + customer  );
        customer.setActive(true);
        customer.setMembership("Gold");

//        CustomerRepository customerRepository = new CustomerRepository();
        return customerRepository.save(customer);

    }
}