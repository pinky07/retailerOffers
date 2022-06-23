package com.point.calculation.customer.amount.controller;

import com.point.calculation.customer.amount.model.CustomerTransaction;
import com.point.calculation.customer.amount.repository.CustomerRepository;
import com.point.calculation.customer.amount.repository.CustomerTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the child relation with Customer
 * child must have some
 * * link/reference to the ParentClass via api (parent/parentid/child for post/get/delete)
 * we can Insert Parent and Child at one request
 */
@RestController
public class CustomerTransactionController {
    @Autowired
    CustomerTransactionRepository transactionRepository;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/tutorials")
    public ResponseEntity<List<CustomerTransaction>> getAllCustomerTransactions(@RequestParam(required = false) LocalDateTime purchaseDate) {
        List<CustomerTransaction> transactions = new ArrayList<CustomerTransaction>();
        if (purchaseDate == null)
            transactionRepository.findAll().forEach(transactions::add);
        else
            transactionRepository.findByPurchaseDate(purchaseDate).forEach(transactions::add);
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}/transactions")
    public ResponseEntity<List<CustomerTransaction>> getAllTransactionByCustomerId(@PathVariable(value = "customerId") Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Not found customerId with id = " + customerId);
        }
        List<CustomerTransaction> comments = transactionRepository.findByCustomerId(customerId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping("/customers/{customerId}/transactions")
    public ResponseEntity<CustomerTransaction> createTransaction(@PathVariable(value = "customerId") Long customerId,
                                                                 @RequestBody CustomerTransaction customerTransaction) {
        CustomerTransaction transaction = customerRepository.findById(customerId).map(customer -> {
            customerTransaction.setCustomer(customer);
            return transactionRepository.save(customerTransaction);
        }).orElseThrow(() -> new RuntimeException("Not found Tutorial with id = " + customerId));
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}
