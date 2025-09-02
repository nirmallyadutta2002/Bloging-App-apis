package com.api.blog.services;

import com.api.blog.paylode.Post_dto;
import java.util.List;

public interface Post_services {

     Post_dto createPost(Post_dto postDto, int userId, int categoryId);

     Post_dto updatePost(Post_dto postDto, int postId);

     void deletePost(int postId);

     List<Post_dto> getAllPosts();

     Post_dto getPostById(int postId);

     List<Post_dto> getPostsByCategory(int categoryId);

     List<Post_dto> getPostsByUser(int userId);
}
