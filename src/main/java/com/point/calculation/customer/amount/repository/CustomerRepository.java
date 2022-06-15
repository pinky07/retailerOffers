package com.point.calculation.customer.amount.repository;

import com.point.calculation.customer.amount.model.Customer;
import com.point.calculation.customer.amount.model.CustomerTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(int id);
}
