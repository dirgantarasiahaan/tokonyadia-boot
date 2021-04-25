package com.mandiri.tokonyadia.service;

import com.mandiri.tokonyadia.entity.Customer;
import com.mandiri.tokonyadia.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private static String notFoundMessage = "Customer with ID : %s Not Found";

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findCustomertById(String customerId) {
        validateCustomer(customerId);
        return customerRepository.findById(customerId).get();
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        customer.setCreatedAt(new Timestamp(new Date().getTime()));
        customer.setUpdatedAt(new Timestamp(new Date().getTime()));
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customer.setUpdatedAt(new Timestamp(new Date().getTime()));
        validateCustomer(customer.getId());
        return customerRepository.save(customer);
    }

    private void validateCustomer(String customerId) {
        if (!customerRepository.findById(customerId).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, customerId));
        }
    }
}
