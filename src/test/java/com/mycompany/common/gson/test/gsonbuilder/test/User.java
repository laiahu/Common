package com.mycompany.common.gson.test.gsonbuilder.test;

import com.google.gson.annotations.Expose;  

public class User {  
    @Expose  
    private Long id;  
      
    @Expose  
    private String name;  
      
    @Expose  
    private User next;  
  
    public Long getId() {  
        return id;  
    }  
  
    public void setId(Long id) {  
        this.id = id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public User getNext() {  
        return next;  
    }  
  
    public void setNext(User next) {  
        this.next = next;  
    }  
}  

