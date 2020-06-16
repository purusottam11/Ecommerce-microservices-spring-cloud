package com.retail.shoping.productservice.repository;

import com.retail.shoping.productservice.model.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByUserName(String userName);

}
