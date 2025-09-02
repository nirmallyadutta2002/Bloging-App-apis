package com.api.blog.controler;

import com.api.blog.paylode.Apiresponce;
import com.api.blog.paylode.CommentDto;
import com.api.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")

public class Comment_controler {
        @Autowired
        private CommentService commentService;

        @PostMapping("/post/{postId}/comments")
        public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId) {

            CommentDto createComment = this.commentService.createComment(comment, postId);
            return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
        }

        @DeleteMapping("/comments/{commentId}")
        public ResponseEntity<Apiresponce> deleteComment(@PathVariable Integer commentId) {

            this.commentService.deleteComment(commentId);

            return new ResponseEntity<Apiresponce>(new Apiresponce("Comment deleted successfully !!", true), HttpStatus.OK);
        }

    }
