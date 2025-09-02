package com.api.blog.controler;
import com.api.blog.paylode.Apiresponce;
import com.api.blog.paylode.Userdto;
import com.api.blog.services.imple.Userserviceimple;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/user")
public class Usercontroler
{
    @Autowired
    Userserviceimple userserviceimple;
    @GetMapping("/")
    ResponseEntity<List<Userdto>> get_all(){
        return ResponseEntity.ok(userserviceimple.getall());
    }
    @PostMapping("/")
    ResponseEntity<Userdto >postUserdto(@Valid @RequestBody Userdto userdto){
        return ResponseEntity.ok(userserviceimple.putUserdto(userdto)); }
    @PutMapping("/{id}")
    ResponseEntity<Userdto> putUserdto(@Valid @RequestBody Userdto userdto, @PathVariable int id){
        return ResponseEntity.ok(userserviceimple.updateUserdto(userdto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Apiresponce> deleteUserdto(@PathVariable int id) {
        userserviceimple.deleteUserdto(id);
        return new ResponseEntity<>(new Apiresponce("User is deleted", true), HttpStatus.OK);
    }
}