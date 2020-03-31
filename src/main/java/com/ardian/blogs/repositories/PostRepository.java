package com.ardian.blogs.repositories;

import java.util.List;

import com.ardian.blogs.common.dto.PostDTO;
import com.ardian.blogs.models.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    
    @Query("FROM Post WHERE title LIKE %:title%")
    List<Post> findByTitle(String title);

    @Query("FROM Post WHERE category.id LIKE :category_id")
    List<Post> findByCategoriesId(Integer category_id);
}