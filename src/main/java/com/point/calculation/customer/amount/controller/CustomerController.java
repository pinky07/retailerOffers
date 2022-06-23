package com.point.calculation.customer.amount.controller;


import com.point.calculation.customer.amount.model.Customer;
import com.point.calculation.customer.amount.repository.CustomerRepository;
import com.point.calculation.customer.amount.repository.CustomerTransactionRepository;
import com.point.calculation.customer.amount.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * The type Customer controller.
 */
@RestController
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    /**
     * The Customer service.
     */
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerTransactionRepository transactionRepository;


    /**
     * Points int.
     *
     * @param amount the amount
     * @return the int
     */
    @PostMapping(value = "/point")
    public int points(@RequestParam Double amount) {
        logger.debug("points");
        return customerService.calculateCustomersPoint(amount);
    }

    /**
     * Customer save customer.
     *
     * @param customer the customer
     * @return the customer
     */
    @PostMapping(value = "/customer")
    public Customer customerSave(@RequestBody Customer customer) {
        logger.debug("customerSave");
        return customerService.saveCustomer(customer);
    }

    /**
     * Gets customer points by id.
     *
     * @param id the id
     * @return the customer points by id
     */
    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomerPointsById(@PathVariable Long id) {
        return customerService.findCustomerPointsById(id);
    }

    @GetMapping("/customer")
    public String getCustomerPoints() {
        return "hello";
    }
}
