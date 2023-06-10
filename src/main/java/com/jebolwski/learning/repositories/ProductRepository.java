package com.jebolwski.learning.repositories;

import com.jebolwski.learning.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
