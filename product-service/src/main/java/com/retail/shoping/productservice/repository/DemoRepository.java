package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.Demo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DemoRepository extends JpaRepository<Demo, String> {

    Demo findByBrand(String brand);

}
