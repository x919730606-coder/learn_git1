package com.bjpowernode.task;

import com.bjpowernode.DlykServerApplication;
import com.bjpowernode.constant.DicEnum;
import com.bjpowernode.entity.TDicType;
import com.bjpowernode.entity.TProduct;
import com.bjpowernode.service.DicTypeService;
import com.bjpowernode.service.ProDuctService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@EnableScheduling
@Component
public class DataTask {
    @Resource
    private DicTypeService dicTypeService;
    @Resource
    private ProDuctService productService;

    @Scheduled(cron = "0 0/30 * * * ?")
    private void task (){
        List<TDicType> dicTypeList = dicTypeService.getDicType();
        for (TDicType dicType : dicTypeList){
            DlykServerApplication.cacheMap.put(dicType.getTypeCode(),dicType.getDicValueList());
        }
        List<TProduct> productList = productService.getProduct();
        DlykServerApplication.cacheMap.put(DicEnum.INTENTION_PRODUCT.getCode(),productList);
        System.out.println(DlykServerApplication.cacheMap);
    }
}
