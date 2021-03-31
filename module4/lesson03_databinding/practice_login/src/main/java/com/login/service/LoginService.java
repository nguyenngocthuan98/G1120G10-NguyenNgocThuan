package com.login.service;

import com.login.model.Login;
import com.login.model.User;

public interface LoginService {
    User checkLogin(Login login);
}
