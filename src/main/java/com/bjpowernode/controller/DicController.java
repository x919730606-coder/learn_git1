package com.bjpowernode.controller;

import com.bjpowernode.entity.TDicValue;
import com.bjpowernode.result.Result;
import com.bjpowernode.service.DicTypeService;
import com.bjpowernode.service.DicValueService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DicController {

    @Resource
    private DicValueService dicValueService;

    @GetMapping("/api/dic/{typeCode}")
    public Result getDicByTypeCode(@PathVariable("typeCode") String typeCode){
        List<TDicValue> dicValueList = dicValueService.getDicValueByTypeCode(typeCode);
        return Result.OK(dicValueList);
    }
}
