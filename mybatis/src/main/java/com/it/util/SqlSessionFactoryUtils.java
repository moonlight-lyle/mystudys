package com.it.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author Lyle
 * @date 2020/10/30
 */
public class SqlSessionFactoryUtils {

    //保证全局只有一个SqlSessionFactory
    public static SqlSessionFactory sqlSessionFactory;

    //使用静态代码块读取文件构建sqlSessionFactory
    static {
        System.out.println("静态代码块执行了。。。。。。。");
        //读取SqlMapConfig.xml
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //构建SqlSessionFactory，相当于连接池
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //定义获取SqlSession的方法
    public static SqlSession getSqlSession() throws Exception {
        //获得连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    //定义释放资源的方法
    public static void commitAndClose(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
