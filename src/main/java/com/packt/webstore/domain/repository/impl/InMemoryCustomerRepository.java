package com.packt.webstore.domain.repository.impl;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository{

    private List<Customer> customers = new ArrayList<>();

    public InMemoryCustomerRepository(){

    Customer customer1 = new Customer("C001", "Martha", "Torun");
    Customer customer2 = new Customer("C002", "Andy", "Berlin");
    Customer customer3 = new Customer("C003", "Michael", "Bydgoszcz");
    customer1.setNoOfOrdersMade(2);
    customer2.setNoOfOrdersMade(3);
    customer3.setNoOfOrdersMade(0);
    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);
    }
 public List<Customer> getAllCustomers(){
        return customers;
 }
}
