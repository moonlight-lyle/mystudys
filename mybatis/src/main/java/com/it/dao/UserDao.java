package com.it.dao;

import com.it.vo.QueryVo;
import com.it.vo.User;
import org.apache.ibatis.annotations.Param;

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

    void insert(User user);

    void batchInsert(List<User> list);

    void batchUpdate(@Param("list") List<User> list);

}
