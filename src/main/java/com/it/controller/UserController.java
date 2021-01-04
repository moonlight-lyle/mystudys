package com.it.controller;

import com.it.pojo.User;
import com.it.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller层
 *
 * @author Lyle
 * @date 2020/7/11
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/findAll")
    public List<User> findList(){
        return userService.findList();
    }
}
