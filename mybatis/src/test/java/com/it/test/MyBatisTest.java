package com.it.test;

import com.it.dao.UserDao;
import com.it.util.SqlSessionFactoryUtils;
import com.it.vo.QueryVo;
import com.it.vo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ToDo
 *
 * @author Lyle
 * @date 2020/10/28
 */
public class MyBatisTest {

    @Test
    public void fun() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用方法
        QueryVo queryVo=new QueryVo();
        User user=new User();
        user.setUid(1);
        user.setUsername("张%");
        queryVo.setUser(user);
        List<User> users = userDao.findByQueryVo(queryVo);
        System.out.println(users);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void fun2() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用方法
        QueryVo queryVo=new QueryVo();
        User user=new User();
        user.setUid(1);
        user.setUsername("张%");
        List<Integer> ids =new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        queryVo.setIds(ids);
        queryVo.setUser(user);
        List<User> users = userDao.findByQueryVo2(queryVo);
        System.out.println(users);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void fun3() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用方法
        QueryVo queryVo=new QueryVo();
        User user=new User();
        user.setUid(1);
        user.setUsername("张%");
        List<Integer> ids =new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        queryVo.setIds(ids);
        queryVo.setUser(user);
        List<User> users = userDao.findByQueryVo3(queryVo);
        System.out.println(users);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void fun4() throws Exception {

    }

    @Test
    public void fun5() throws Exception {

    }
}
