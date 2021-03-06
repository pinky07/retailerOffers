package com.point.calculation.customer.amount.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Builder
@Data
@Entity(name = "customer")
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "address")
    private String address;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "points")
    private int points;
    /**
     * notice here we have linktable for child table, but we dont have any column
     * specific for child,so in parent table we will not have child column
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Set<CustomerTransaction> customerTransaction;

}
