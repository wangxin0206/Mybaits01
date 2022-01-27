package com.demo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author June
 * @date 2022/1/6 17:35
 */
//SqlSessionFactory-->SqlSession

    /*
    * 问题记录：
    *       1、配置文件没有注册
    *       2、绑定接口错误
    *       3、方法名不对
    *       4、返回类型不对
    *       5、Maven导出资源问题
    * */
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //使用mybatis第一步，获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}