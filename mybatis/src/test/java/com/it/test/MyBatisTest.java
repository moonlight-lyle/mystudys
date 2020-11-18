package com.it.test;

import com.it.dao.UserDao;
import com.it.util.SqlSessionFactoryUtils;
import com.it.vo.QueryVo;
import com.it.vo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用单个插入方法
        User user=new User("赵六","男",new Date(),"广州");
        userDao.insert(user);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    @Test
    public void fun5() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用批量插入方法
        List<User> list=new ArrayList<>();
        User user=new User(17,"田七","男",new Date(),"广州");
        User user2=new User(18,"老九","男",new Date(),"深圳");
        User user3=new User(19,"何时","女",new Date(),"深圳");
        list.add(user);
        list.add(user2);
        list.add(user3);
        userDao.batchInsert(list);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);

    }

    @Test
    public void fun6() throws Exception {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用批量更新方法
        List<User> list=new ArrayList<>();
        User user=new User();
        user.setUid(17);
        user.setUsername("kk");
        User user2=new User();
        user2.setUid(18);
        user2.setUsername("jj");
        User user3=new User();
        user3.setUid(19);
        user3.setUsername("mm");
        list.add(user);
        list.add(user2);
        list.add(user3);
        userDao.batchUpdate(list);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);

    }
}
