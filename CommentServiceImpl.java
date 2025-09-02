package com.api.blog.services.imple;

import com.api.blog.entitey.Comment;
import com.api.blog.entitey.Post;
import com.api.blog.exception.ResourceNotfoundexception;
import com.api.blog.paylode.CommentDto;
import com.api.blog.repo.CommentRepo;
import com.api.blog.repo.Post_repo;
import com.api.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private Post_repo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotfoundexception("Post", "post id ", postId));

        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment com = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotfoundexception("Comment", "CommentId", commentId));
        this.commentRepo.delete(com);
    }
}
