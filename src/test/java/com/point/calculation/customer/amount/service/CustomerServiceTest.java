package com.point.calculation.customer.amount.service;


import com.point.calculation.customer.amount.model.Customer;
import com.point.calculation.customer.amount.model.CustomerTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @InjectMocks
    private CustomerService customerService;
    private Customer customer;

    @BeforeEach
    public void setup() {
        LocalDateTime datetime1 = LocalDateTime.of(2017, 1, 14, 10, 34);
        customer = Customer.builder()
                .id(1L)
                .firstName("Ramesh")
                .lastName("Fadatare")
                .address("USA")
                .build();
        CustomerTransaction.builder()
                .id(1L)
                .amount(90)
                .customer(customer)
                .purchaseDate(datetime1)
                .build();
    }

    // JUnit test for calculateCustomersPoint method
    @DisplayName("JUnit test for calculateCustomersPoint method")
    @Test
    public void givenAmountMoreThan50() {


        // when -  action or the behaviour that we are going test
        int actual = customerService.calculateCustomersPoint(90.0);
        // then - verify the output
        assertEquals(40, actual);
    }

    @Test
    public void givenAmountMoreThan100() {


        // when -  action or the behaviour that we are going test
        int actual = customerService.calculateCustomersPoint(120.0);
        // then - verify the output
        assertEquals(90, actual);
    }

    @Test
    public void givenAmountBetween50And100() {


        // when -  action or the behaviour that we are going test
        int actual = customerService.calculateCustomersPoint(70.0);
        // then - verify the output
        assertEquals(20, actual);
    }

    @Test
    public void givenAmountLessThan50() {

        // when -  action or the behaviour that we are going test
        int actual = customerService.calculateCustomersPoint(10.0);
        // then - verify the output
        assertEquals(0, actual);
    }

    @Test
    public void givenAmountMoreThan50WithDecimal() {

        // when -  action or the behaviour that we are going test
        int actual = customerService.calculateCustomersPoint(50.51);
        // then - verify the output
        assertEquals(1, actual);
    }
}