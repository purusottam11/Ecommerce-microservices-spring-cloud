package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrandRepository extends BaseRepository<Brand> {

    @Query("select c from Brand c where c.name=:name")
    Brand findByName(@Param("name") String name);

}
