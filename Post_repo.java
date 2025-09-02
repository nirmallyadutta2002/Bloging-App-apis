package com.api.blog.repo;

import com.api.blog.entitey.Category;
import com.api.blog.entitey.Post;
import com.api.blog.entitey.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Post_repo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
