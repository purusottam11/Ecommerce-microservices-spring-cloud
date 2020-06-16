package com.retail.shoping.productservice.serviceimpl;

import com.retail.shoping.productservice.exception.BusinessException;
import com.retail.shoping.productservice.exception.ErrorCode;
import com.retail.shoping.productservice.model.User;
import com.retail.shoping.productservice.repository.UserRepository;
import com.retail.shoping.productservice.service.UserService;
import com.retail.shoping.productservice.utils.XoriskUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User addUser(User user) {
        userRepository.findById(user.getId()).ifPresent(
                i -> {
                    throw new BusinessException("UserId " + i.getId() + " is already exist");
                });
        userRepository.findByUserName(user.getUserName()).ifPresent(
                i -> {
                    throw new BusinessException("userName " + i.getUserName() + " is already exist");
                });
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User user1 = userRepository.findById(user.getId()).orElseThrow(
                () -> new BusinessException(ErrorCode.USER_NOT_FOUND.getMessage()));
        XoriskUtils.copySafe(user, user1);
        return userRepository.save(user1);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new BusinessException(ErrorCode.USER_NOT_FOUND.getMessage()));
        userRepository.deleteById(userId);
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new BusinessException(ErrorCode.USER_NOT_FOUND.getMessage()));
        return userRepository.getOne(userId);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
