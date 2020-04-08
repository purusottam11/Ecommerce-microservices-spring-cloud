package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.FlipkartProducts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlipkartProductsRepository extends JpaRepository<FlipkartProducts, String> {

    FlipkartProducts  findByBrand(String brand);

}
