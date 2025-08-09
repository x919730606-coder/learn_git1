package com.bjpowernode.service;

import com.bjpowernode.entity.TUser;
import com.bjpowernode.query.UserQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

//我们的处理登录的service接口，需要继承spring security框架的UserDetailsService接口
public interface UserService extends UserDetailsService {

    PageInfo<TUser> getUserByPage(Integer current);

    TUser getUserById(Integer id);

    int saveUser(UserQuery userQuery);

    int updateUser(UserQuery userQuery);

    int deleteUser(Integer id);

    int bathDeleteUser(List<String> list);

    List<TUser> getOwners();
}
