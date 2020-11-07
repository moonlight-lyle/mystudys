package com.it.dao;

import com.it.vo.QueryVo;
import com.it.vo.User;

import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/10/28
 */
public interface UserDao {

    List<User> findByQueryVo(QueryVo queryVo);

    List<User> findByQueryVo2(QueryVo queryVo);

    List<User> findByQueryVo3(QueryVo queryVo);

}
