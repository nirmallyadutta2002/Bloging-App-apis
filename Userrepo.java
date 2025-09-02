package com.api.blog.repo;

import com.api.blog.entitey.User; // ✅ Correct import
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface Userrepo extends JpaRepository<User, Integer> {
}
