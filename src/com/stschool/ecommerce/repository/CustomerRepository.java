package com.stschool.ecommerce.repository;

import com.stschool.ecommerce.model.Customer;
import com.stschool.ecommerce.util.CsvUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private final List<Customer> customerList;

    public CustomerRepository() throws IOException {
        this.customerList = CsvUtil.readCustomersFromCsv();
    }


    //CRUD operations
    /*
    Create (save)
    Read (element / group of elements / all elements )
    Update (element / group of elements / all elements )
    Delete (element / group of elements / all elements )
     */

    public Customer save(Customer customer){
        customerList.add(customer);
        return customer;
    }

    public Customer findByEmail(String email){
        //logic to find customer by email
        Customer customerByEmail = null;
        for (Customer customer : customerList){
            if (customer.getEmail().equals(email)){
                customerByEmail = customer;
            }
        }return customerByEmail;

    }

    public Customer findByPhone(String phone){

        Customer customerByPhone = null;
        for (Customer customer : customerList){
            if(customer.getPhone().equals(phone)){
                customerByPhone = customer;
            }
        }
        return customerByPhone;
    }

    //This is login method also both ways
    public Customer findByEmailAndPassword(String email, String password){
        Customer customerByEmailAndPassword = null;
        for(Customer customer: customerList){
            if(customer.getEmail().equals(email) && customer.getPassword().equals(password)){
                customerByEmailAndPassword = customer;
            }
        }
        return customerByEmailAndPassword;
    }

    public List<Customer> findAll(){
        return customerList;
    }

    //update Customer
    public Customer update(Customer customer){
       int index = 0;
       for(Customer c : customerList){
           if(c.getEmail().equals(customer.getEmail())){
               customerList.set(index, customer);
               return customer;
           }
           index++;
       }
       return null;

    }

    //delete Customer
    public void delete(String email){
        customerList.remove(findByEmail(email));
    }

}