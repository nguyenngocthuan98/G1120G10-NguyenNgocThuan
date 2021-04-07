package com.validate.exercise_validate.repositories;

import com.validate.exercise_validate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposiory extends JpaRepository<User, Integer> {
}
