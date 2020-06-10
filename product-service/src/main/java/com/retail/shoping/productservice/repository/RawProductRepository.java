package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.RawProducts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RawProductRepository extends JpaRepository<RawProducts, String> {

    RawProducts findByBrand(String brand);

}
