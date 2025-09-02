package com.api.blog.services.imple;
import com.api.blog.entitey.User;
import com.api.blog.exception.ResourceNotfoundexception;
import com.api.blog.paylode.Userdto;
import com.api.blog.repo.Userrepo;
import com.api.blog.services.Userservices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class Userserviceimple implements Userservices {
    @Autowired
    private Userrepo userrepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Userdto putUserdto(Userdto userdto) {
        User user =dtotouser(userdto);
        User u =this.userrepo.save(user);
        return usertodto(u);
    }
    @Override
    public Userdto updateUserdto(Userdto userdto, int id) {
        User user = this.userrepo.findById(id)
                .orElseThrow(() -> new ResourceNotfoundexception("User", "UID", id));
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setAbout(userdto.getAbout());
        User updatedUser = this.userrepo.save(user);
        return usertodto(updatedUser);
    }

    @Override
    public void deleteUserdto(int id) {
        User user =this.userrepo.findById(id).orElseThrow(()->new ResourceNotfoundexception("User","UID",id));
        this.userrepo.delete(user);
    }

    @Override
    public List<Userdto> getall() {
        List<User> user=  this.userrepo.findAll();
        List<Userdto>use=user.stream().map(i->this.usertodto(i)).collect(Collectors.toList());
        return use;
    }
    private User dtotouser(Userdto userdto) {
        User user = this.modelMapper.map(userdto,User.class);
//        user.setId(userdto.getId());
//        user.setName(userdto.getName());
//        user.setEmail(userdto.getEmail());
//        user.setPassword(userdto.getPassword());
//        user.setAbout(userdto.getAbout());
        return user;
    }
    private Userdto usertodto(User user) {
        Userdto userdto=this.modelMapper.map(user,Userdto.class);
//        userdto.setId(user.getId());
//        userdto.setName(user.getName());
//        userdto.setEmail(user.getEmail());
//        userdto.setPassword(user.getPassword());
//        userdto.setAbout(user.getAbout());
        return userdto;
    }
}