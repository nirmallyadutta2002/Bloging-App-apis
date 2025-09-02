package com.api.blog.entitey;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "post_id")
    private int post_id;
    private String title;
    private String content;
    private String image;
    private Date aded_date;
    private boolean live;
    @ManyToOne
    private User user;
    @ManyToOne
    private  Category category;

}
