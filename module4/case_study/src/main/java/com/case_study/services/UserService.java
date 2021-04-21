package com.case_study.services;

import com.case_study.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    User createUserByUsername(String username);

    void changePassword(User user, String newPassword);
}
