package com.api.blog.paylode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class Apiresponce {
    private String message;
    private  boolean success;
    public Apiresponce(String message, boolean success){
        this.message=message;
        this.success=success;
    }
}
