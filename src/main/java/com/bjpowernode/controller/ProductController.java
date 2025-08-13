package com.bjpowernode.controller;

import com.bjpowernode.entity.TProduct;
import com.bjpowernode.result.Result;
import com.bjpowernode.service.DicValueService;
import com.bjpowernode.service.ProDuctService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Resource
    private ProDuctService proDuctService;
    @GetMapping("api/products")
    public Result getProducts(){
        List<TProduct> list = proDuctService.getProduct();
        return Result.OK(list);
    }
}
