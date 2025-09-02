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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String email;
    private String password;
    private String about;

    // FIX: mappedBy must match the field name in Post ("user")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> list = new ArrayList<>();
}
