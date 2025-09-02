package com.api.blog.repo;

import com.api.blog.entitey.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface Category_repo extends JpaRepository<Category, Integer> {
    
}
