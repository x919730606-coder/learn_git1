package com.bjpowernode.service;

import com.bjpowernode.entity.TActivity;
import com.bjpowernode.query.ActivityQuery;
import com.github.pagehelper.PageInfo;

public interface ActivityService {
    PageInfo<TActivity> getActivitiesByPage(Integer current, ActivityQuery activityQuery);
}
