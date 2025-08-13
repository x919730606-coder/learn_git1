package com.bjpowernode.service;

import com.bjpowernode.entity.TClue;
import com.bjpowernode.query.ClueRemarkQuery;
import com.github.pagehelper.PageInfo;

public interface ClueRemarkService {

    int saveClueRemark(ClueRemarkQuery clueRemarkQuery);

    PageInfo<TClue> getClueRemarkByPage(Integer current, Integer clueId);
}
