package com.maradinho.customer.model.dao;

import com.maradinho.customer.model.bo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
