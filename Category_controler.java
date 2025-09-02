package com.api.blog.controler;

import com.api.blog.paylode.Apiresponce;
import com.api.blog.paylode.Category_dto;
import com.api.blog.services.imple.Category_services_imple;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class Category_controler {

    @Autowired
    private Category_services_imple category_services_imple;

    @GetMapping("/")
ResponseEntity<List<Category_dto>> get_all_data(){
    return ResponseEntity.ok (category_services_imple.getAllCategories());
     }
     @PostMapping("/")
    ResponseEntity<Category_dto> post_data(@Valid @RequestBody  Category_dto category_dto ){
    return ResponseEntity.ok(category_services_imple.createCategory(category_dto));
     }
     @PutMapping("/{id}")
    ResponseEntity<Category_dto> update_data(@Valid @RequestBody Category_dto category_dto,@PathVariable int id){
        return ResponseEntity.ok(category_services_imple.updateCategory(category_dto,id));
     }
     @GetMapping("/{id}")
    ResponseEntity<Category_dto> Get_data_by_id(@PathVariable int id){
        return ResponseEntity.ok(category_services_imple.getCategoryById(id));
     }
     @DeleteMapping("/{id}")
    ResponseEntity<Apiresponce> Delete(@PathVariable int id){
        category_services_imple.deleteCategory(id);
        return new ResponseEntity<>(new Apiresponce("Data is delete",true), HttpStatus.OK);
     }

}
