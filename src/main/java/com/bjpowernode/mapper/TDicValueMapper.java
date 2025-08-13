package com.bjpowernode.mapper;

import com.bjpowernode.entity.TDicValue;

import java.util.List;

public interface TDicValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TDicValue record);

    int insertSelective(TDicValue record);

    TDicValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TDicValue record);

    int updateByPrimaryKey(TDicValue record);

    List<TDicValue> getDicValueByTypeCode(String typeCode);
}