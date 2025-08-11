package com.bjpowernode.service.impl;

import com.bjpowernode.entity.TActivityRemark;
import com.bjpowernode.mapper.TActivityRemarkMapper;
import com.bjpowernode.query.ActivityRemarkQuery;
import com.bjpowernode.service.ActivityRemarkService;
import com.bjpowernode.util.LoginInfoUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActivityRemarkServiceImpl implements ActivityRemarkService {
    @Resource
    private TActivityRemarkMapper tActivityRemarkMapper;

    @Override
    public int saveRemark(ActivityRemarkQuery activityRemarkQuery) {
        TActivityRemark activityRemark = new TActivityRemark();
        activityRemark.setActivityId(activityRemarkQuery.getActivityId());
        activityRemark.setNoteContent(activityRemarkQuery.getNoteContent());
        activityRemark.setCreateTime(new Date());
        activityRemark.setCreateBy(LoginInfoUtil.getCurrentLoginUser().getId());
        return tActivityRemarkMapper.insertSelective(activityRemark);
    }
}
