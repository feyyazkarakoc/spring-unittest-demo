package com.tpe.controller;


import com.tpe.domain.Customer;
import com.tpe.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
        Customer customer = customerService.getCustomer(id);
        return ResponseEntity.ok(customer);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("id") Long id){

        customerService.deleteCustomer(id);

        return ResponseEntity.ok("Customer is deleted.");

    }
}
