package com.demo.dao;

import com.demo.pojo.User;

import java.util.List;

/**
 * @author June
 * @date 2022/1/6 17:44
 */
public interface Userdao {
    //获取全部用户
    List<User> getUserList();
    //根据id查询用户
    User getUserbyid(int id);
    //insert 插入一个用户
    int addUser(User user);
    //update用户
    int updateUser(User user);
    //删除一个用户
    int deleteUser(int id);
}
