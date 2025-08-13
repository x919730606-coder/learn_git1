package com.bjpowernode.controller;

import com.bjpowernode.query.CustomerQuery;
import com.bjpowernode.result.Result;
import com.bjpowernode.service.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @PostMapping("api/customer")
    public Result addCustomer(@RequestBody CustomerQuery customerQuery){
        boolean flag = customerService.convertCustomer(customerQuery);
        return flag ? Result.OK() : Result.FAIL();
    }
}
