package com.bjpowernode.service;

import com.bjpowernode.query.ActivityRemarkQuery;
import org.springframework.stereotype.Service;


public interface ActivityRemarkService {
    int saveRemark(ActivityRemarkQuery activityRemarkQuery);
}
