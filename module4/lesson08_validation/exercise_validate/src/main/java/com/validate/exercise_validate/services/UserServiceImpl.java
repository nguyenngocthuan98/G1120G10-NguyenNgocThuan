package com.validate.exercise_validate.services;

import com.validate.exercise_validate.models.User;
import com.validate.exercise_validate.repositories.UserReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserReposiory userReposiory;

    @Override
    public void save(User user) {
        userReposiory.save(user);
    }
}
