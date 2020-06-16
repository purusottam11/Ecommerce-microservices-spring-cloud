package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends BaseRepository<Category> {

    Optional<Category> findByName(String name);

}
