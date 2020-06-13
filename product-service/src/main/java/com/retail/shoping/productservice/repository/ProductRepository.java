package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   // @Query("select c from Product c where c.productName=:productName")
    Optional<Product> findByProductName(String productName);

    //@Query("select c from Product c where c.pid=:pid")
    Optional<Product> findByPid(String pid);

}
