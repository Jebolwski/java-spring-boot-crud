package com.jebolwski.learning.repositories;

import com.jebolwski.learning.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
