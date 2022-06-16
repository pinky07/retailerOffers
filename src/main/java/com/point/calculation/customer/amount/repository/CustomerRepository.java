package com.point.calculation.customer.amount.repository;

import com.point.calculation.customer.amount.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(int id);
}
