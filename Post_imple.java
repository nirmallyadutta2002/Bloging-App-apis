package com.api.blog.services.imple;

import com.api.blog.entitey.Category;
import com.api.blog.entitey.Post;
import com.api.blog.entitey.User;
import com.api.blog.exception.ResourceNotfoundexception;
import com.api.blog.paylode.Category_dto;
import com.api.blog.paylode.Post_dto;
import com.api.blog.paylode.Userdto;
import com.api.blog.repo.Category_repo;
import com.api.blog.repo.Post_repo;
import com.api.blog.repo.Userrepo;
import com.api.blog.services.Post_services;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Post_imple implements Post_services {
    @Autowired
    Userrepo userrepo;
    @Autowired
    Post_repo postRepo;
    @Autowired
    Category_repo category_repo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Post_dto createPost(Post_dto postDto, int userId, int categoryId) {
              Post post=modelMapper.map(postDto,Post.class);
              User user=this.userrepo.findById(userId).
              orElseThrow(()->new ResourceNotfoundexception("User","Userid",userId));
              Category category=this.category_repo.findById(categoryId).
              orElseThrow(()->new ResourceNotfoundexception("Category","Categoryid",categoryId));
              post.setImage("default.png");
              post.setAded_date(new Date());
              post.setUser(user);
              post.setCategory(category);
        Post new_post = this.postRepo.save(post);
        Post_dto responseDto = modelMapper.map(new_post, Post_dto.class);
        responseDto.setUser(modelMapper.map(user,Userdto.class));
        responseDto.setCategory(modelMapper.map(category,Category_dto.class));
        return responseDto ;
    }

    @Override
    public Post_dto updatePost(Post_dto postDto, int postId) {
        Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotfoundexception("post","post_id",postId));
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setImage(postDto.getImage());
        Post post1=this.postRepo.save(post);
        return modelMapper.map(post1, Post_dto.class);
    }

    @Override
    public void deletePost(int postId) {
        Post post=this.postRepo.findById(postId).
                orElseThrow(()->new ResourceNotfoundexception("post","Postid",postId));
        this.postRepo.delete(post);
    }

    @Override
    public List<Post_dto> getAllPosts() {
        List<Post>posts=this.postRepo.findAll();
        List<Post_dto>posts1=posts.stream().
                map((i)->modelMapper.map(i, Post_dto.class)).collect(Collectors.toList());
        return posts1;
    }

    @Override
    public Post_dto getPostById(int postId) {
        Post post=this.postRepo.findById(postId).
                orElseThrow(()->new ResourceNotfoundexception("post","postid",postId));
        Post_dto new_postdto=modelMapper.map(post, Post_dto.class);
        return new_postdto;
    }

    @Override
    public List<Post_dto> getPostsByCategory(int categoryId) {
        Category cat =this.category_repo.findById(categoryId).
                orElseThrow(()->new ResourceNotfoundexception
                        ("category","ctegoryid",categoryId));
        List<Post> post=this.postRepo.findByCategory(cat);
        List<Post_dto>post1=post.stream().
                map((i)->modelMapper.map(i, Post_dto.class))
                .collect(Collectors.toList());
        return post1;
    }

    @Override
    public List<Post_dto> getPostsByUser(int userId) {
        User user=this.userrepo.findById(userId).
                orElseThrow(()->new ResourceNotfoundexception
                        ("uuser","userid",userId));
        List<Post>postu=this.postRepo.findByUser(user);
        List<Post_dto>postDtos=postu.stream().
                map((i)->modelMapper.map(i, Post_dto.class))
                .collect(Collectors.toList());
        return postDtos;
    }

}
