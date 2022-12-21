package com.group6.customer_ordering.service.impl;

import com.group6.customer_ordering.entity.Customers;
import com.group6.customer_ordering.entity.projection.CustomerProjection;
import com.group6.customer_ordering.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group6.customer_ordering.service.CustomerService;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerProjection> findAll() {
        return this.customerRepository.findCustomerProjectionBy();
    }

    @Override
    public Customers findByUsernameContainsIgnoreCase(String username) {
        return (Customers) customerRepository.findByUsernameContainsIgnoreCase(username);
    }
    @Override
    public Customers findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customers createNewCustomer(Customers customer) {
        try{
            customer.setUsername(customer.getUsername());
            customer.setPhone(customer.getPhone());
            customer.setAddress(customer.getAddress());
            customer.setEmail(customer.getEmail());
            customer.setGender(customer.getGender());
            return customerRepository.save(customer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Customers updateExistingCustomer(Customers customers) {
        return customerRepository.save(customers);
    }

    @Override
    public void delete(Long id) {
        this.customerRepository.deleteById(id);
    }

}
