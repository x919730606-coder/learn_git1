package com.bjpowernode.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.bjpowernode.constant.Constant;
import com.bjpowernode.entity.TPermission;
import com.bjpowernode.entity.TRole;
import com.bjpowernode.entity.TUser;
import com.bjpowernode.mapper.TPermissionMapper;
import com.bjpowernode.mapper.TRoleMapper;
import com.bjpowernode.mapper.TUserMapper;
import com.bjpowernode.query.BaseQuery;
import com.bjpowernode.query.UserQuery;
import com.bjpowernode.service.UserService;
import com.bjpowernode.util.LoginInfoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //逆向工程、反向工程（根据数据库表，生成mapper接口、mapper.xml、实体类）

    @Resource
    private TUserMapper tUserMapper;

    @Resource
    private TPermissionMapper tPermissionMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private TRoleMapper tRoleMapper;

    /**
     * 该方法在spring security框架登录的时候被调用
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询数据库，查询页面上传过来的这个用户名是否在数据库中存在，也就是根据该username查询用户对象
        TUser tUser = tUserMapper.selectByLoginAct(username);
        if (tUser == null) {
            throw new UsernameNotFoundException("登录账号不存在");
        }

        List<TRole> tRoles = tRoleMapper.selectByUserId(tUser.getId());
        tUser.setTRoleList(tRoles);

        //查询该用户的权限code列表（一个用户可能有多个权限code）
        List<TPermission> tPermissionList = tPermissionMapper.selectByUserId(tUser.getId());
        //把查询出来的角色放入用户对象中
        tUser.setTPermissionList(tPermissionList);

        //返回该用户对象
        return tUser;
    }

    @Override
    public PageInfo<TUser> getUserByPage(Integer current) {
        PageHelper.startPage(current, Constant.PAGE_SIZE);
        List<TUser> tUserList = tUserMapper.selectByPage(new BaseQuery());
        PageInfo<TUser> pageInfo = new PageInfo<>(tUserList);
        return pageInfo;
    }

    @Override
    public TUser getUserById(Integer id) {
        return tUserMapper.getUserById(id);
    }

    @Override
    public int saveUser(UserQuery userQuery) {

        TUser tUser = new TUser();

        BeanUtils.copyProperties(userQuery, tUser);

        String pwd = passwordEncoder.encode(userQuery.getLoginPwd());
        tUser.setLoginPwd(pwd);
        tUser.setCreateTime(new Date());
        tUser.setCreateBy(LoginInfoUtil.getCurrentLoginUser().getId());
        return tUserMapper.insertSelective(tUser);
    }

    @Override
    public int updateUser(UserQuery userQuery) {
        TUser tUser = new TUser();
        BeanUtils.copyProperties(userQuery, tUser);
        if (StringUtils.hasText(userQuery.getLoginPwd())){
            tUser.setLoginPwd(passwordEncoder.encode(userQuery.getLoginPwd()));
        }
        tUser.setEditTime(new Date());
        tUser.setEditBy(LoginInfoUtil.getCurrentLoginUser().getId());
        return tUserMapper.updateByPrimaryKeySelective(tUser);
    }

    @Override
    public int deleteUser(Integer id) {
        return tUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int bathDeleteUser(List<String> list) {
        return tUserMapper.bathDeleteUser(list);
    }

    @Override
    public List<TUser> getOwners() {
        return tUserMapper.getOwners();
    }
}
