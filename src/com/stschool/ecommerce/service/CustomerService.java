package com.stschool.ecommerce.service;

import com.stschool.ecommerce.exception.CustomerExistsException;
import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.repository.CustomerRepository;

import java.io.IOException;
import java.util.List;

public class CustomerService {

    private final CustomerRepository customerRepository;

   public CustomerService(CustomerRepository customerRepository) {
       this.customerRepository = customerRepository;
   }

    public Customer register(Customer customer){
        System.out.println("Customer Service Register Method called");
        //check whether customer already exists or not

        Customer customerByEmail = customerRepository.findByEmail(customer.getEmail());
        if(customerByEmail != null){
            throw new CustomerExistsException("Customer already exists with this email");
        }


        customer.setActive(true);
        customer.setMembership("Gold");
        System.out.println("Customer Details: " + customer  );
//   remove this   CustomerRepository customerRepository = new CustomerRepository();
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}