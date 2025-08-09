package com.bjpowernode.service.impl;

import com.bjpowernode.constant.Constant;
import com.bjpowernode.entity.TActivity;
import com.bjpowernode.mapper.TActivityMapper;
import com.bjpowernode.query.ActivityQuery;
import com.bjpowernode.query.BaseQuery;
import com.bjpowernode.service.ActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private TActivityMapper tActivityMapper;
    @Override
    public PageInfo<TActivity> getActivitiesByPage(Integer current, ActivityQuery activityQuery) {
        PageHelper.startPage(current, Constant.PAGE_SIZE);
        List<TActivity> tList = tActivityMapper.selectByPage(new BaseQuery(),activityQuery);
        PageInfo<TActivity> pageInfo = new PageInfo<>(tList);
        return pageInfo;
    }
}
