package com.point.calculation.customer.amount.repository;

import com.point.calculation.customer.amount.model.CustomerTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Long> {

    List<CustomerTransaction> getCustomerById(Long id);

    List<CustomerTransaction> findByPurchaseDate(LocalDateTime purchaseDate);

    List<CustomerTransaction> findByCustomerId(Long tutorialId);
}
