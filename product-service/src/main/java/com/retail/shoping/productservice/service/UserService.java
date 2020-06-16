package com.retail.shoping.productservice.service;

import com.retail.shoping.productservice.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    User getUser(Long userId);

    List<User> getUsers();

}
