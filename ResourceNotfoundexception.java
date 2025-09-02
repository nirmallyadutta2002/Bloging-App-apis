package com.api.blog.exception;

public class ResourceNotfoundexception extends RuntimeException{
    String user;
    String id;
    int userid;

public ResourceNotfoundexception(String user,String id,int userid){
    super(String.format("User %s not found %s= %s",user,id,userid));
    this.user=user;
    this.id=id;
    this.userid=userid;
 }
}
