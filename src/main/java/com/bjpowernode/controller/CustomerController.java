package com.bjpowernode.controller;

import com.bjpowernode.entity.TCustomer;
import com.bjpowernode.query.CustomerQuery;
import com.bjpowernode.result.Result;
import com.bjpowernode.service.CustomerService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @PostMapping("api/customer")
    public Result addCustomer(@RequestBody CustomerQuery customerQuery){
        boolean flag = customerService.convertCustomer(customerQuery);
        return flag ? Result.OK() : Result.FAIL();
    }

    @GetMapping("api/customers")
    public Result getCustomers(@RequestParam Integer num){
        PageInfo<TCustomer> pageInfo = customerService.getCustomers(num);
        return Result.OK(pageInfo);
    }

    @GetMapping("api/exportExcel")
    public void exportExcel(HttpServletResponse response,String ids) throws IOException {
        List<String> idList = null;
        if (StringUtils.hasText(ids)){
            idList = Arrays.asList(ids.split(","));
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); //Excel
        response.setCharacterEncoding("utf-8");

        //告诉前端我们是返回一个文件
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + System.currentTimeMillis() + ".xlsx");
        OutputStream outputStream = response.getOutputStream();
        customerService.exportExcel(outputStream,idList);
    }

    @GetMapping("api/customer/{id}")
    public Result getCustomer(@PathVariable Integer id){
        TCustomer customer = customerService.getCustomerById(id);
        return Result.OK(customer);
    }
}
