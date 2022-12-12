package com.peaksoft.service;

import com.peaksoft.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User saveUser(User user);
    void deleteUserById(Long id);
}
