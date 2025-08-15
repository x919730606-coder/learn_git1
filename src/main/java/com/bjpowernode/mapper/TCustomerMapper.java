package com.bjpowernode.mapper;

import com.bjpowernode.annotation.DataScope;
import com.bjpowernode.entity.TCustomer;
import com.bjpowernode.query.BaseQuery;

import java.util.List;

public interface TCustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCustomer record);

    int insertSelective(TCustomer record);

    TCustomer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TCustomer record);

    int updateByPrimaryKey(TCustomer record);


    List<TCustomer> selectByPage(List<String> idList);

    TCustomer SelectById(Integer id);

    int selectTotalCustomerCount();
}