package com.ardian.blogs.repositories;

import java.util.List;

import com.ardian.blogs.models.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    
    @Query("FROM Author WHERE username LIKE %:username%")
    List<Author> findByUsername(String username);
}