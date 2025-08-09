package com.bjpowernode.mapper;

import com.bjpowernode.annotation.DataScope;
import com.bjpowernode.entity.TUser;
import com.bjpowernode.query.BaseQuery;

import java.util.List;

//@Mapper
public interface TUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    TUser selectByLoginAct(String loginAct);

    @DataScope(tableAlias = "tu", columnName = "id")
    List<TUser> selectByPage(BaseQuery baseQuery);

    TUser getUserById(Integer id);

    int bathDeleteUser(List<String> list);

    List<TUser> getOwners();
}