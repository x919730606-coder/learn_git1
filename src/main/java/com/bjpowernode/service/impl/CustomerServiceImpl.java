package com.bjpowernode.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.bjpowernode.entity.TClue;
import com.bjpowernode.entity.TCustomer;
import com.bjpowernode.mapper.TClueMapper;
import com.bjpowernode.mapper.TCustomerMapper;
import com.bjpowernode.query.CustomerQuery;
import com.bjpowernode.service.CustomerService;
import com.bjpowernode.util.LoginInfoUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private TClueMapper tClueMapper;
    @Resource
    private TCustomerMapper tCustomerMapper;
    @Override
    public boolean convertCustomer(CustomerQuery customerQuery) {
        TClue tClue = tClueMapper.selectById(customerQuery.getClueId());
        if (tClue.getState() == -1){
            throw new RuntimeException("该线索已转换");
        }
        TCustomer tCustomer = new TCustomer();

        BeanUtils.copyProperties(customerQuery, tCustomer);
        tCustomer.setCreateTime(new Date());
        tCustomer.setCreateBy(LoginInfoUtil.getCurrentLoginUser().getId());
        int insert = tCustomerMapper.insertSelective(tCustomer);
        TClue upClue = new TClue();
        upClue.setId(customerQuery.getClueId());
        upClue.setState(-1);
        int update = tClueMapper.updateByPrimaryKeySelective(upClue);
        return insert > 0 && update > 0;
    }
}
