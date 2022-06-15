package com.point.calculation.customer.amount.controller;


import com.point.calculation.customer.amount.model.Customer;
import com.point.calculation.customer.amount.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/point")
   public int points( @RequestParam Double amount) {
        logger.debug("points");
        return customerService.calculateCustomersPoint(amount);
    }
    @PostMapping(value = "/customer")
    public Customer customerSave(@RequestBody Customer customer) {
        logger.debug("customerSave");
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomerPointsById(@PathVariable Long id) {
        return customerService.findCustomerPointsById(id);
    }
}
