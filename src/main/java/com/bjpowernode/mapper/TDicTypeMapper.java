package com.bjpowernode.mapper;

import com.bjpowernode.entity.TDicType;
import com.bjpowernode.entity.TDicValue;

import java.util.List;

public interface TDicTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TDicType record);

    int insertSelective(TDicType record);

    TDicType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TDicType record);

    int updateByPrimaryKey(TDicType record);

    List<TDicType> getDicTypes();

    List<TDicValue> getDicValueByTypeCode(String typeCode);
}