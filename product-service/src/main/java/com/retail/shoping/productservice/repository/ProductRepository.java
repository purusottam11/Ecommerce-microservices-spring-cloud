package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("select c from Product c where c.productName=:productName")
    Product findByProductName(String productName);

    @Query("select c from Product c where c.pid=:pid")
    Product findByPid(@Param("pid") String pid);

}
