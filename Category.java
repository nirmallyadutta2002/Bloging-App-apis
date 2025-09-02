package com.api.blog.entitey;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Category_id;

    private String title;
    private String description;

    // FIX: mappedBy must match the field name in Post ("category")
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Post> list = new ArrayList<>();
}
