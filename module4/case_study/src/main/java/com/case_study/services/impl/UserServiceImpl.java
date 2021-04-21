package com.case_study.services.impl;

import com.case_study.models.User;
import com.case_study.repositories.UserRepository;
import com.case_study.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User createUserByUsername(String username) {
        List<User> listUser = findAll();
        for (User user : listUser) {
            if (user.getUsername().equals(username)) {
                return null;
            }
        }
        User user = new User();

        user.setUsername(username);
        user.setPassword(username);
        user.setEnabled(true);

        save(user);
        return user;
    }

    @Override
    public void changePassword(User user, String newPassword) {
        if (!user.getPassword().equals(newPassword)) {
            user.setPassword(newPassword);
        }

        save(user);
    }
}
