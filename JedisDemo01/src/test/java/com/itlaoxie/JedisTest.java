package com.itlaoxie;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @ClassName JedisTest
 * @Description: TODO
 * @Author: ChuXiaoLin
 **/
public class JedisTest {
    @Test
    public void test01(){
        // 连接 Redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 针对于数据设置和获取

        // 设置数据
        jedis.set("myJavaFromRedis","Jedis");

        // 获取数据
        String myJavaFromRedis = jedis.get("myJavaFromRedis");

        // 输出
        System.out.println(myJavaFromRedis);

        // 关闭连接 Redis
        jedis.close();
    }

    @Test
    public void test02(){
        // 连接 Redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 对数据的操作

        Long rpush = jedis.rpush("names", "Andy", "Tom", "Jack", "Boby", "ZhangSan");
        System.out.println("rpush =" + rpush);

        List<String> names = jedis.lrange("names", 0, -1);

        for (String name : names) {
            System.out.println(name);
        }

        // 关闭 Redis
        jedis.close();
    }

    @Test
    public void test03(){
        // 连接 Redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 对数据的操作

        // Long hset = jedis.hset("myhash", "stu", "itxiaosi");
        // System.out.println(hset);
        //
        // String stu = jedis.hget("myhash", "stu");
        // System.out.println(stu);

        Map<String, String> map = new HashMap<>();
        map.put("stu01","itxiaosi");
        map.put("age","23");
        map.put("sex","boy");
        map.put("dep","student");

        jedis.hmset("student01",map);

        List<String> stu01 = jedis.hmget("student01","stu01","age","sex","dep");
        System.out.println(stu01);

        // 关闭 Redis
        jedis.close();
    }

    @Test
    public void test04(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.sadd("mySet","this'sJavaForRedisSet","two","three");

        Set<String> mySet = jedis.smembers("mySet");
        System.out.println(mySet);


        jedis.close();
    }

    @Test
    public void test05(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.zadd("mySortSet",1,"a");
        jedis.zadd("mySortSet",2,"b");
        jedis.zadd("mySortSet",3,"c");
        Set<String> mySortSet = jedis.zrange("mySortSet", 0, -1);
        System.out.println(mySortSet);

        jedis.close();
    }

    @Test
    public void test06(){
        System.out.println(Long.MAX_VALUE);
    }
}
