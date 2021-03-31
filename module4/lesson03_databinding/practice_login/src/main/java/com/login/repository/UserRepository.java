package com.login.repository;

import com.login.model.Login;
import com.login.model.User;

public interface UserRepository {
    User checkLogin(Login login);
}
