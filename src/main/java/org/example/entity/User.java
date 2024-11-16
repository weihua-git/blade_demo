package org.example.entity;

import com.hellokaton.anima.Model;

public class User extends Model {
    private Integer id;
    private String userName;
    private Integer age;
    // getter 和 setter 省略


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}