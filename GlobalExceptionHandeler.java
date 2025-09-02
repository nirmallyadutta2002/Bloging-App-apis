package com.api.blog.exception;
import com.api.blog.paylode.Apiresponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class GlobalExceptionHandeler {
    private final View error;

    public GlobalExceptionHandeler(View error) {
        this.error = error;
    }

    @ExceptionHandler(ResourceNotfoundexception.class)
    public ResponseEntity<Apiresponce> ResourceNotfoundexception(ResourceNotfoundexception ex){
        String message=ex.getMessage();
        Apiresponce apiresponce=new Apiresponce(message,false);
        return new ResponseEntity<>(apiresponce, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>>MethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String>repo=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{
          String filed= ((FieldError)error).getField();
          String message=error.getDefaultMessage();
          repo.put(filed,message);
        });
        return new ResponseEntity<Map<String,String>>(repo,HttpStatus.BAD_REQUEST);
    }
}
