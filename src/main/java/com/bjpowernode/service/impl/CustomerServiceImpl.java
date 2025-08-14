package com.bjpowernode.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.bjpowernode.constant.Constant;
import com.bjpowernode.entity.TClue;
import com.bjpowernode.entity.TCustomer;
import com.bjpowernode.mapper.TClueMapper;
import com.bjpowernode.mapper.TCustomerMapper;
import com.bjpowernode.query.BaseQuery;
import com.bjpowernode.query.CustomerExcel;
import com.bjpowernode.query.CustomerQuery;
import com.bjpowernode.service.CustomerService;
import com.bjpowernode.util.LoginInfoUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public PageInfo<TCustomer> getCustomers(Integer num) {
        PageHelper.startPage(num, Constant.PAGE_SIZE);
        List<TCustomer> tCustomerList = tCustomerMapper.selectByPage(null);
        PageInfo<TCustomer> pageInfo = new PageInfo<>(tCustomerList);
        return pageInfo;
    }

    @Override
    public void exportExcel(OutputStream outputStream, List<String> idList) {

        List<TCustomer> tCustomerList = tCustomerMapper.selectByPage(idList);

        List<Object> tCustomerExcelList = new ArrayList<>();

        for (TCustomer tCustomer : tCustomerList){
            CustomerExcel customerExcel = new CustomerExcel();
            customerExcel.setFullName(tCustomer.getClueDo().getFullName());
            customerExcel.setAppellationName(tCustomer.getAppellationDo().getTypeValue());
            customerExcel.setPhone(tCustomer.getClueDo().getPhone());
            customerExcel.setWeixin(tCustomer.getClueDo().getWeixin());
            customerExcel.setIntentionProductName(tCustomer.getIntentionProductDo().getName());
            tCustomerExcelList.add(customerExcel);
        }
        EasyExcel.write(outputStream, CustomerExcel.class).sheet().doWrite(tCustomerExcelList);
    }

    @Override
    public TCustomer getCustomerById(Integer id) {
        TCustomer tCustomer = tCustomerMapper.SelectById(id);
        return tCustomer;
    }
}
