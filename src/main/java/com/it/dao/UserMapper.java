package com.it.dao;

import com.it.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/4/1
 */
@Repository
public interface UserMapper {

    public List<User> findAll();
}