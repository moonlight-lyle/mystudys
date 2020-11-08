package com.it.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis工具类操作Redis
 *
 * @author Lyle
 * @date 2019/12/25
 */
public class JedisUtils {
    //创建全局变量以便静态代码块中可以使用
    private static JedisPoolConfig jedisPoolConfig;
    private static JedisPool jedisPool;

    static {

        //因为JedisPool只需要创建和配置一次,所以放入静态代码块比较好
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);    //最多连接数量
        jedisPoolConfig.setMaxWaitMillis(1000); //等待时间
        // 2. 创建JedisPool对象
        String host = "127.0.0.1";
        int port = 6379;
        jedisPool = new JedisPool(jedisPoolConfig, host, port);
    }

    //对外提供get方法获得jedis,静态方法,类名调用比较好
    public static Jedis getJedis() {
        // 3. 从JedisPool获得jedis
        Jedis jedis = jedisPool.getResource();
        return jedis;

    }

    //释放资源
    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}