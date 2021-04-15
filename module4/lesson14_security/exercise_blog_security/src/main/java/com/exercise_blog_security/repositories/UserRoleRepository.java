package com.exercise_blog_security.repositories;

import com.exercise_blog_security.entity.AppUser;
import com.exercise_blog_security.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
