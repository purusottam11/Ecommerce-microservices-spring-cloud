package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends BaseRepository<Category> {

    @Query("select c from Category c where c.name=:name")
    Category findByName(@Param("name") String name);
}
