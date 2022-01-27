package com.demo.dao;

import com.demo.pojo.User;
import com.demo.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author June
 * @date 2022/1/7 14:16
 */
public class UserDaoTest {
    //查询所有用户
    @Test
    public void test() {
        //第一步：获取sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try {
            //getMapper     方式一
            Userdao userdao=sqlSession.getMapper(Userdao.class);
            List<User> userList=userdao.getUserList();
            //方式二
            //List<User> userList1=sqlSession.selectList("com.demo.dao.Userdao.getUserList");

            for (User user:userList) {
                System.out.println(user.getId()+user.getName()+user.getPwd());
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭
            sqlSession.close();
        }
    }
    //根据id查询用户
    @Test
    public void getUserbyid() {
        //第一步：获取sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try {
            //getMapper     方式一
            Userdao userdao=sqlSession.getMapper(Userdao.class);
            User user=userdao.getUserbyid(1);
            //方式二
            //List<User> userList1=sqlSession.selectList("com.demo.dao.Userdao.getUserList");
            System.out.println(user.getId()+user.getName()+user.getPwd());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭
            sqlSession.close();
        }
    }
    //添加一个用户
    @Test
    public void addUser() {
        //第一步：获取sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try {
            //getMapper     方式一
            Userdao userdao=sqlSession.getMapper(Userdao.class);
            int number = userdao.addUser(new User(3,"信","333"));
            if(number!=0){
                System.out.println("插入成功！！！");
            }
            //提交事务
            sqlSession.commit();
            //方式二
            //List<User> userList1=sqlSession.selectList("com.demo.dao.Userdao.getUserList");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭
            sqlSession.close();
        }
    }
    //修改某个用户
    @Test
    public void updateUser() {
        //第一步：获取sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try {
            //getMapper     方式一
            Userdao userdao=sqlSession.getMapper(Userdao.class);
            int number = userdao.updateUser(new User(3,"sndi","323243"));
            if(number!=0){
                System.out.println("修改成功！！！");
            }
            //提交事务
            sqlSession.commit();
            //方式二
            //List<User> userList1=sqlSession.selectList("com.demo.dao.Userdao.getUserList");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭
            sqlSession.close();
        }
    }
    //删除某个用户
    @Test
    public void deleteUser() {
        //第一步：获取sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try {
            //getMapper     方式一
            Userdao userdao=sqlSession.getMapper(Userdao.class);
            int number = userdao.deleteUser(3);
            if(number!=0){
                System.out.println("删除成功！！！");
            }
            //提交事务
            sqlSession.commit();
            //方式二
            //List<User> userList1=sqlSession.selectList("com.demo.dao.Userdao.getUserList");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭
            sqlSession.close();
        }
    }
}
