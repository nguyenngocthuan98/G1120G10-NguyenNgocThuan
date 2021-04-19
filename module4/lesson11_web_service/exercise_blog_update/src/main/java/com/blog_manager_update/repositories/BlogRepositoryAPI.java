package com.blog_manager_update.repositories;

import com.blog_manager_update.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepositoryAPI extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByTitleContaining(String searchText);
}