package com.mandiri.tokonyadia.service;

import com.mandiri.tokonyadia.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    public Page<Customer> findAllCustomer(Pageable pageable);
    public Customer findCustomertById(String customerId);
    public Customer createNewCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
}
