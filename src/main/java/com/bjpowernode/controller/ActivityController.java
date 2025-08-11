package com.bjpowernode.controller;

import com.bjpowernode.entity.TActivity;
import com.bjpowernode.query.ActivityQuery;
import com.bjpowernode.result.Result;
import com.bjpowernode.service.ActivityService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
    @Resource
    private ActivityService activityService;
    @GetMapping("/api/activities")
    public Result getActivities(Integer current ,ActivityQuery activityQuery){
        PageInfo<TActivity> pageInfo = activityService.getActivitiesByPage(current,activityQuery);
        return Result.OK(pageInfo);
    }
    @GetMapping("/api/activity/{id}")
    public Result getActivityById(@PathVariable Integer id){
        TActivity activity = activityService.getActivityById(id);
        return Result.OK(activity);
    }

}
