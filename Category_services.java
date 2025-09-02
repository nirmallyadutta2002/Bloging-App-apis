package com.api.blog.services;

import com.api.blog.paylode.Category_dto;
import java.util.List;

public interface Category_services {

    // Create
    Category_dto createCategory(Category_dto categoryDto);

    // Update
    Category_dto updateCategory(Category_dto categoryDto, int id);

    // Delete
    void deleteCategory(int id);

    // Get all
    List<Category_dto> getAllCategories();

    // Get by id
    Category_dto getCategoryById(int id);
}
