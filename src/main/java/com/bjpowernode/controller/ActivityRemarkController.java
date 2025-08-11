package com.bjpowernode.controller;

import com.bjpowernode.query.ActivityRemarkQuery;
import com.bjpowernode.result.Result;
import com.bjpowernode.service.ActivityRemarkService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityRemarkController {
    @Resource
    private ActivityRemarkService activityRemarkService;

    @PostMapping("/api/acticityRemark")
    public Result addActivityRemark(@RequestBody ActivityRemarkQuery activityRemarkQuery){
        int number = activityRemarkService.saveRemark(activityRemarkQuery);
        return number > 0 ? Result.OK(): Result.FAIL();
    }
}
