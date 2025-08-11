package com.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.ProductDetails;

public interface ProductRepository extends JpaRepository<ProductDetails, Integer> {
}
