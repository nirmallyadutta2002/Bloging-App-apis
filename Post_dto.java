package com.api.blog.paylode;

import com.api.blog.entitey.Category;
import com.api.blog.entitey.User;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Post_dto {
    private int post_id;

    @NotEmpty
    @Size(min = 5, message = "Title must be at least 5 characters")
    private String title;

    @NotEmpty
    @Size(min = 20, message = "Content must be at least 20 characters")
    private String content;
    private String image;
    private Date aded_date;
    private boolean live;
    private Userdto user;
    private Category_dto category;

}
