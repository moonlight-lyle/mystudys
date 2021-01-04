package com.it.service.impl;

import com.it.dao.UserMapper;
import com.it.pojo.User;
import com.it.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/7/11
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findList() {
        return userMapper.findAll();
    }
}
