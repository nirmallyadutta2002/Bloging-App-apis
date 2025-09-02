package com.api.blog.services;

import com.api.blog.paylode.Userdto;

import java.util.List;


public interface Userservices {
    Userdto putUserdto(Userdto userdto);
     Userdto   updateUserdto(Userdto userdto,int id);
    void deleteUserdto(int id);
    List<Userdto> getall();
}
