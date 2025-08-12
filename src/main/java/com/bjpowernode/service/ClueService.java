package com.bjpowernode.service;

import com.bjpowernode.entity.TClue;
import com.github.pagehelper.PageInfo;

import java.io.InputStream;

public interface ClueService {
    PageInfo<TClue> getClueByPage(Integer num);

    void importExcel(InputStream inputStream);
}
