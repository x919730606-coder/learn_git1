package com.bjpowernode.controller;

import com.bjpowernode.entity.TUser;
import com.bjpowernode.query.UserQuery;
import com.bjpowernode.result.Result;
import com.bjpowernode.service.UserService;
import com.bjpowernode.util.LoginInfoUtil;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Generated;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("api/login/user")
    public Result getUser() {
        TUser currentLoginUser = LoginInfoUtil.getCurrentLoginUser();
        return Result.OK(currentLoginUser);
    }

    @GetMapping("api/users")
    public Result getUsers(Integer current){
        PageInfo<TUser> pageInfo = userService.getUserByPage(current);
        return Result.OK(pageInfo);
    }

    @GetMapping("api/user/{id}")
    public Result getUserById(@PathVariable Integer id){
        TUser tUser = userService.getUserById(id);
        return Result.OK(tUser);
    }

    @PostMapping("api/user")
    public Result addUser(UserQuery userQuery){
        int count = userService.saveUser(userQuery);
        return count == 1 ? Result.OK() : Result.FAIL();
    }

    @PutMapping("api/user")
    public Result updateUser(UserQuery userQuery){
        int count = userService.updateUser(userQuery);
        return count == 1 ? Result.OK() : Result.FAIL();
    }

    @DeleteMapping("api/user/{id}")
    public Result deleteUser(@PathVariable Integer id){
        int count = userService.deleteUser(id);
        return count == 1 ? Result.OK() : Result.FAIL();
    }

    @DeleteMapping("api/user")
    public Result deleteUsers(@RequestParam String ids){
        List<String> list = Arrays.asList(ids.split(","));
        int count = userService.bathDeleteUser(list);
        return count == list.size() ? Result.OK() : Result.FAIL();
    }

    @GetMapping("api/owners")
    public Result getOwners(){
        List<TUser> list = userService.getOwners();
        return Result.OK(list);
    }
}
