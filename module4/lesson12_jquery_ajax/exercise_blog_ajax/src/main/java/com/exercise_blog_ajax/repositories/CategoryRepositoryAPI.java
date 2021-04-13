package com.exercise_blog_ajax.repositories;

import com.exercise_blog_ajax.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepositoryAPI extends JpaRepository<Category, Integer> {

}
