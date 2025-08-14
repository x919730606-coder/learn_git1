package com.bjpowernode.service;

import com.bjpowernode.entity.TCustomer;
import com.bjpowernode.query.CustomerQuery;
import com.github.pagehelper.PageInfo;

import java.io.OutputStream;
import java.util.List;

public interface CustomerService {
    boolean convertCustomer(CustomerQuery customerQuery);

    PageInfo<TCustomer> getCustomers(Integer num);

    void exportExcel(OutputStream outputStream, List<String> idList);

    TCustomer getCustomerById(Integer id);
}
