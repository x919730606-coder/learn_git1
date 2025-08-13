package com.bjpowernode.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.bjpowernode.constant.Constant;
import com.bjpowernode.entity.TClue;
import com.bjpowernode.entity.TClueRemark;
import com.bjpowernode.mapper.TClueRemarkMapper;
import com.bjpowernode.query.ClueRemarkQuery;
import com.bjpowernode.service.ClueRemarkService;
import com.bjpowernode.util.LoginInfoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClueRemarkServiceImpl implements ClueRemarkService {

    @Resource
    private TClueRemarkMapper clueRemarkMapper;

    @Override
    public int saveClueRemark(ClueRemarkQuery clueRemarkQuery) {
        TClueRemark tClueRemark = new TClueRemark();
        BeanUtils.copyProperties(clueRemarkQuery, tClueRemark);
        tClueRemark.setCreateTime(new Date());
        tClueRemark.setCreateBy(LoginInfoUtil.getCurrentLoginUser().getId());
        return clueRemarkMapper.insertSelective(tClueRemark);
    }

    @Override
    public PageInfo<TClue> getClueRemarkByPage(Integer current, Integer clueId) {
        PageHelper.startPage(current,Constant.PAGE_SIZE);
        List<TClue> tClueList = clueRemarkMapper.selectByPage(clueId);
        PageInfo<TClue> pageInfo = new PageInfo<>(tClueList);
        return pageInfo;
    }
}
