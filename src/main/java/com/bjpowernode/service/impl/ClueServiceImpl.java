package com.bjpowernode.service.impl;

import com.alibaba.excel.EasyExcel;
import com.bjpowernode.constant.Constant;
import com.bjpowernode.entity.TClue;
import com.bjpowernode.entity.TUser;
import com.bjpowernode.listener.ClueExcelListener;
import com.bjpowernode.mapper.TClueMapper;
import com.bjpowernode.query.BaseQuery;
import com.bjpowernode.query.ClueExcel;
import com.bjpowernode.service.ClueService;
import com.bjpowernode.util.LoginInfoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class ClueServiceImpl implements ClueService {

    @Resource
    private TClueMapper tClueMapper;

    @Override
    public PageInfo<TClue> getClueByPage(Integer num) {
        PageHelper.startPage(num, Constant.PAGE_SIZE);
        List<TClue> tClueList = tClueMapper.selectByPage(new BaseQuery());
        PageInfo<TClue> pageInfo = new PageInfo<>(tClueList);
        return pageInfo;
    }

    @Override
    public void importExcel(InputStream inputStream) {
        TUser currentLoginUser = LoginInfoUtil.getCurrentLoginUser();
        Integer id = currentLoginUser.getId();
        EasyExcel.read(inputStream, ClueExcel.class, new ClueExcelListener(tClueMapper, id)).sheet().doRead();
    }
}
