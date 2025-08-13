package com.bjpowernode.mapper;

import com.bjpowernode.entity.TClue;
import com.bjpowernode.entity.TClueRemark;

import java.util.List;

public interface TClueRemarkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TClueRemark record);

    int insertSelective(TClueRemark record);

    TClueRemark selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TClueRemark record);

    int updateByPrimaryKey(TClueRemark record);

    List<TClue> selectByPage(Integer clueId);
}