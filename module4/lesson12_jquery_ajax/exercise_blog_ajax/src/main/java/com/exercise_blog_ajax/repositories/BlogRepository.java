package com.exercise_blog_ajax.repositories;

import com.exercise_blog_ajax.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByTitleContaining(String searchText, Pageable pageable);
}
