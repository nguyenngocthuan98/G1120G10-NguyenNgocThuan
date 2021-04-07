package com.blog.exercise_upgrade_blog.repositories;

import com.blog.exercise_upgrade_blog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
