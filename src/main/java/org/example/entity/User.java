package org.example.entity;

import com.hellokaton.anima.Model;

public class User extends Model {
    
    private Integer id;
    private String  userName;
    private Integer age;
    
    public User() {
    }
    
    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }
    
}