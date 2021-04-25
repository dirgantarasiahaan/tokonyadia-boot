package com.mandiri.tokonyadia.controller;

import com.mandiri.tokonyadia.entity.Customer;
import com.mandiri.tokonyadia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public Page<Customer> findAllCustomer(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                          @RequestParam(name = "size", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return customerService.findAllCustomer(pageable);
    }

    @GetMapping("/customer/{id}")
    public Customer findCustomerById(@PathVariable(name = "id") String customerId){
        return customerService.findCustomertById(customerId);
    }

    @PostMapping("/customer")
    public Customer createNewCustomer(@RequestBody Customer customer){
        return customerService.createNewCustomer(customer);
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

}
