package com.login.repository.Impl;

import com.login.model.Login;
import com.login.model.User;
import com.login.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("john", "123456", "John", "john@codegym.vn", 23));
        users.add(new User("jame", "123456", "Jame", "jame@codegym.vn", 23));
        users.add(new User("admin", "admin", "Admin", "admin@localhost.com", 0));
        users.add(new User("ken", "123456", "Ken", "ken@codegym.vn", 23));
        users.add(new User("andy", "123456", "Andy", "andy@codegym.vn", 23));
        users.add(new User("tim", "123456", "Tim", "tim@codegym.vn", 23));
    }

    @Override
    public User checkLogin(Login login) {
        for (User user : users) {
            if (user.getAccount().equals(login.getAccount()) && user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
