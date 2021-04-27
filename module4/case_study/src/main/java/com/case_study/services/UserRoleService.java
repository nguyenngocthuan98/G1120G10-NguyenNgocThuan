package com.case_study.services;

import com.case_study.models.Employee;
import com.case_study.models.User;
import com.case_study.models.UserRole;

public interface UserRoleService {
    void save(UserRole userRole);

    void createUserRole(User user, Employee employee);

    void updateUserRole(Employee employee);

    boolean isDirectorRole(User user);
}
