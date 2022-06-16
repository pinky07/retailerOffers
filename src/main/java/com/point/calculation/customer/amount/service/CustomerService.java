package com.point.calculation.customer.amount.service;

import com.point.calculation.customer.amount.controller.CustomerController;
import com.point.calculation.customer.amount.exception.CustomerNotFoundException;
import com.point.calculation.customer.amount.model.Customer;
import com.point.calculation.customer.amount.repository.CustomerRepository;
import com.point.calculation.customer.amount.repository.CustomerTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerTransactionRepository customerTransactionRepository;

    public int calculateCustomersPoint(Double amount) {
        logger.trace("<<calculateCustomersPoint");
        if (amount <= 0) {
            throw new CustomerNotFoundException("amount must be greater than zero");
        }
        int point = 0;
        if (Math.round(amount) > 50 && Math.round(amount) < 100) {
            point = (int) Double.parseDouble(String.valueOf(Math.round(amount) - 50));
        } else if (Math.round(amount) > 100) {
            point = (int) Double.parseDouble(String.valueOf((Math.round(amount) - 50) * 1 + (Math.round(amount) - 100) * 1));
        } else {
            point = 0;
        }
        logger.trace("calculateCustomersPoint>>");
        return point;

    }


    public Optional<Customer> findCustomerPointsById(Long id) {
        if (customerRepository.findById(id) == null)
            throw new CustomerNotFoundException("Customer not found with id," + id);
        return customerRepository.findById(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
