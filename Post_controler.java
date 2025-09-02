package com.api.blog.controler;
import com.api.blog.paylode.Apiresponce;
import com.api.blog.paylode.Post_dto;
import com.api.blog.services.imple.Post_imple;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/Apis")
public class Post_controler {
   @Autowired
    Post_imple postImple;
   @PostMapping("/User/{id}/Category/{category_id}/post")
    ResponseEntity<Post_dto>Create_post(@Valid @RequestBody Post_dto postDto,
                                        @PathVariable int id,
                                        @PathVariable int category_id){
       Post_dto postDto1=this.postImple.createPost(postDto,id,category_id);
       return ResponseEntity.ok(postDto1);
   }
    @PutMapping("/{postId}")
    public ResponseEntity<Post_dto> updatePost(
            @RequestBody Post_dto postDto,
            @PathVariable int postId) {
        Post_dto updatedPost = this.postImple.updatePost(postDto, postId);
        return ResponseEntity.ok(updatedPost);
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<Apiresponce> deletePost(@PathVariable int postId) {
        this.postImple.deletePost(postId);
        return new ResponseEntity<>(new Apiresponce("Post deleted successfully", true), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Post_dto>> getAllPosts() {
        return ResponseEntity.ok(this.postImple.getAllPosts());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post_dto> getPostById(@PathVariable int postId) {
        return ResponseEntity.ok(this.postImple.getPostById(postId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Post_dto>> getPostsByCategory(@PathVariable int categoryId) {
        return ResponseEntity.ok(this.postImple.getPostsByCategory(categoryId));
    }

    @GetMapping("/User/{id}")
    public ResponseEntity<List<Post_dto>> getPostsByUser(@PathVariable int userId) {
        return ResponseEntity.ok(this.postImple.getPostsByUser(userId));
    }

}
