package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
