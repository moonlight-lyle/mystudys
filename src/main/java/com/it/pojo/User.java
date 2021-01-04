package com.it.pojo;

import java.io.Serializable;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/4/1
 */
public class User implements Serializable {
    private Integer id;
    private String username;//用户名
    private String password;//密码
    private String name;//姓名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}