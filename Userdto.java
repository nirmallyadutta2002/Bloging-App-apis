package com.api.blog.paylode;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@NoArgsConstructor
@Getter
@Setter
public class Userdto
{
    private int  id;
    @NotEmpty
    @Size(min =4 ,max = 20, message = "User name must be 4 characters or within 20 characters")
    private String name;
    @Email(message = "Email is not valid")
    private String email;
    @NotEmpty
    @Size(min=4, max=20, message = "Password must be 4 digit or within 20 digit")
    private String password;
    @NotEmpty
    @Size(min = 4,message = "About must be 4 character")
    private String about;
}