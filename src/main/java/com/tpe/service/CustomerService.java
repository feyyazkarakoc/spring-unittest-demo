package com.tpe.service;


import com.tpe.domain.Customer;
import com.tpe.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long id) {

        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not found!"));

    }


    public void deleteCustomer(Long id) {
        getCustomer(id);
        customerRepository.deleteById(id);
    }
}
