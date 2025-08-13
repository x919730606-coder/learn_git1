package com.bjpowernode.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.bjpowernode.DlykServerApplication;
import com.bjpowernode.constant.DicEnum;
import com.bjpowernode.entity.TProduct;

import java.util.List;

public class IntentionProductConverter implements Converter<Integer> {
    @Override
    public Integer convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String excelValue = cellData.getStringValue(); //读取到的Excel单元格的数据
        //转成java中的Integer
        List<TProduct> tProductList =  (List<TProduct>) DlykServerApplication.cacheMap.get(DicEnum.INTENTION_PRODUCT.getCode());
        for (TProduct tProduct : tProductList) {
            Integer id = tProduct.getId();
            String name = tProduct.getName();
            if (excelValue.equals(name)) {
                return id;
            }
        }
        return tProductList.get(0).getId();
    }
}
