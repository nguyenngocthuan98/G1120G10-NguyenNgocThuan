package com.case_study.services;

import com.case_study.models.User;
import org.springframework.validation.Errors;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    User findByUsername(String username);

    User createUserByUsername(String username);

    void changePassword(User user, String newPassword);

    void checkUsername(String username, Errors errors);
}
