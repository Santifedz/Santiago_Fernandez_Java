package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepo;

    // Create a new customer record.
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer){
        return customerRepo.save(customer);
    }

    // Update an existing customer record
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomerById(@RequestBody Customer customer){
        customerRepo.save(customer);
    }

    // Delete an existing customer record
    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomer(@PathVariable int id){
        customerRepo.deleteById(id);
    }

    // Find a customer record by id.
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable int id){
        Optional<Customer> foundCustomer = customerRepo.findById(id);
        return foundCustomer.orElse(null);
    }

    // Find customer records by state
    @GetMapping("/customers/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomerByState(@PathVariable String state){
        return customerRepo.findByState(state);
    }
    
}
